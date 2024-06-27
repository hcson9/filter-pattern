package com.sparta.filterpattern.product.repository;

import com.sparta.filterpattern.common.exception.DataNotFoundException;
import com.sparta.filterpattern.product.model.Category;
import com.sparta.filterpattern.product.model.Product;
import com.sparta.filterpattern.product.model.YN;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
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
public class ProductJdbcTemplateRepository implements ProductRepository {

  private final JdbcTemplate jdbcTemplate;

  @Override
  public List<Product> findAll() {

    String sql = """
        SELECT id, name, price, category, sold_yn, created_at
        FROM product
        """;

    List<Product> products = jdbcTemplate.query(sql, new ProductRowMapper());

    if (CollectionUtils.isEmpty(products)) {
      throw new DataNotFoundException("product is Empty!!");
    }

    return products;
  }

  @Override
  public Optional<Product> findById(long id) {
    String sql = """
        SELECT id, name, price, category, sold_yn, created_at
        FROM product
        WHERE id = ?
        """;
    Product product = jdbcTemplate.queryForObject(sql, new ProductRowMapper(), id);

    return Optional.of(product);
  }


  class ProductRowMapper implements RowMapper<Product> {

    @Override
    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
      Long id = rs.getLong("id");
      String name = rs.getString("name");
      Double price = rs.getDouble("price");
      String category = rs.getString("category");
      String soldYn = rs.getString("sold_yn");
      LocalDateTime createdAt = rs.getTimestamp("created_at").toLocalDateTime();

      return new Product(id, name, price, Category.getByString(category), YN.getByString(soldYn),
          createdAt);
    }
  }
}

