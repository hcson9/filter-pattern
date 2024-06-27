package com.sparta.filterpattern.product.repository;

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
public interface ProductRepository {

  List<Product> findAll();

  Optional<Product> findById(long id);
}
