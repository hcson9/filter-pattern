package com.sparta.filterpattern.product.service;

import com.sparta.filterpattern.product.filter.ProductFilter;
import com.sparta.filterpattern.product.model.Product;
import com.sparta.filterpattern.product.repository.ProductJpaRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * create on 2024/05/16 create by IntelliJ IDEA.
 *
 * <p> New Project. </p>
 *
 * @author HoChan Son (hcson)
 * @version 1.0
 * @since 1.0
 */
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

  private final ProductJpaRepository repository;

  private final ProductFilter filter = initFilter();

  public Product save(Product product) {
    return repository.save(product);
  }

  /**
   * 전체 찾기.
   *
   * @return 조회된 상품
   */
  public List<Product> findAll() {
    return repository.findAll()
        .stream()
        .filter(p -> filter.check(p))
        .toList();
  }

  @Override
  public Product findById(long id) {
    return repository.findById(id).orElseThrow(() -> new RuntimeException("error"));
  }
}
