package com.sparta.filterpattern.product.repository;

import com.sparta.filterpattern.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * create on 2024/05/17 create by IntelliJ IDEA.
 *
 * <p> New Project. </p>
 *
 * @author HoChan Son (hcson)
 * @version 1.0
 * @since 1.0
 */
public interface ProductJpaRepository extends JpaRepository<Product, Integer>, ProductRepository {

}
