package com.sparta.filterpattern.product.service;

import com.sparta.filterpattern.product.filter.ProductCategoryFilter;
import com.sparta.filterpattern.product.filter.ProductFilter;
import com.sparta.filterpattern.product.filter.ProductSoldYnFilter;
import com.sparta.filterpattern.product.model.Product;
import java.util.List;
import java.util.Optional;

/**
 * create on 2024/06/13 create by IntelliJ IDEA.
 *
 * <p> New Project. </p>
 *
 * @author HoChan Son (hcson)
 * @version 1.0
 * @since 1.0
 */
public interface ProductService {

  List<Product> findAll();

  Product findById(long id);

  default ProductFilter initFilter() {
    // 품절 여부 필터 등록
    ProductFilter productFilter = new ProductSoldYnFilter();

    // 카테고리 필터
    return productFilter.add(new ProductCategoryFilter());
  }
}
