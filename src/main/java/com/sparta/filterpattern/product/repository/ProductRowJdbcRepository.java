package com.sparta.filterpattern.product.repository;

import com.sparta.filterpattern.common.exception.DataNotFoundException;
import com.sparta.filterpattern.product.model.Category;
import com.sparta.filterpattern.product.model.Product;
import com.sparta.filterpattern.product.model.YN;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.util.CollectionUtils;

/**
 * create on 2024/06/13 create by IntelliJ IDEA.
 *
 * <p> New Project. </p>
 *
 * @author HoChan Son (hcson)
 * @version 1.0
 * @since 1.0
 */
@RequiredArgsConstructor
public class ProductRowJdbcRepository implements ProductRepository {

  private final String url;

  private final String userName;

  private final String password;

  private final String driverClassName;

  private Connection getConnection() throws SQLException, ClassNotFoundException {
    Class.forName(driverClassName);
    return DriverManager.getConnection(url, userName, password);
  }

  @Override
  public List<Product> findAll() {
    String sql = """
        SELECT id, name, price, category, sold_yn, created_at
        FROM product
        """;
    List<Product> products = new ArrayList<>();
    try (Connection conn = getConnection()) {
      Statement stmt = conn.createStatement();
      ResultSet rs = stmt.executeQuery(sql);

      while (rs.next()) {
        products.add(convertToProduct(rs));
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    } catch (ClassNotFoundException e) {
      throw new RuntimeException(e);
    }
    if (CollectionUtils.isEmpty(products)) {
      throw new DataNotFoundException("No products found");
    }
    return products;
  }

  @Override
  public Optional<Product> findById(long id) {
    String sql = """
            SELECT id, name, price, category, sold_yn, created_at
            FROM product
            WHERE id = #{id}
            """;

    sql = parseParam(sql, "id", id + "");
    try (Connection conn = getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql)) {
      if (rs.next()) {
        return Optional.of(convertToProduct(rs));
      } else {
        return Optional.empty();
      }
    } catch (SQLException | ClassNotFoundException e) {
      throw new RuntimeException(e);
    }
  }

  private String parseParam(String query, String key, String value) {
    StringBuilder keyBuilder = new StringBuilder();
    keyBuilder = keyBuilder.append("#{")
        .append(key)
        .append("}");
    return query.replace(keyBuilder.toString(), value);
  }

  private Product convertToProduct(ResultSet rs) throws SQLException {
    Long id = rs.getLong(1);
    String name = rs.getString(2);
    Double price = rs.getDouble(3);
    String category = rs.getString(4);
    String sold_yn = rs.getString(5);
    LocalDateTime createdAt = rs.getTimestamp(6).toLocalDateTime();

    return new Product(id, name, price, Category.getByString(category),
        YN.getByString(sold_yn), createdAt);
  }
}
