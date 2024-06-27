package com.sparta.filterpattern.product.service;

import com.sparta.filterpattern.product.filter.ProductFilter;
import com.sparta.filterpattern.product.model.Product;
import com.sparta.filterpattern.product.repository.ProductJdbcTemplateRepository;
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
public class ProductJdbcTemplateServiceImpl implements ProductService {

  private final ProductJdbcTemplateRepository repository;

  private final ProductFilter filter = initFilter();

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
