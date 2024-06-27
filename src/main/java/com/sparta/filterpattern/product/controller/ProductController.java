package com.sparta.filterpattern.product.controller;

import com.sparta.filterpattern.product.model.Product;
import com.sparta.filterpattern.product.service.ProductRowJdbcServiceImpl;
import com.sparta.filterpattern.product.service.ProductJdbcTemplateServiceImpl;
import com.sparta.filterpattern.product.service.ProductServiceImpl;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * create on 2024/05/20 create by IntelliJ IDEA.
 *
 * <p> New Project. </p>
 *
 * @author HoChan Son (hcson)
 * @version 1.0
 * @since 1.0
 */
@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

  private final ProductServiceImpl service;

  private final ProductRowJdbcServiceImpl connService;

  private final ProductJdbcTemplateServiceImpl jdbcService;

  /**
   * findAll.
   *
   * @return products.
   */
  @GetMapping("/jpa")
  public ResponseEntity<List<Product>> findAll() {
    return ResponseEntity.ok(
        service.findAll()
    );
  }

  /**
   * findAll.
   *
   * @return products.
   */
  @GetMapping("/jdbc-template")
  public ResponseEntity<List<Product>> findAll2() {
    return ResponseEntity.ok(
        jdbcService.findAll()
    );
  }

  /**
   * findAll.
   *
   * @return products.
   */
  @GetMapping("/row-jdbc")
  public ResponseEntity<List<Product>> findAll3() {
    return ResponseEntity.ok(
        connService.findAll()
    );
  }

  /**
   * findAll.
   *
   * @return products.
   */
  @GetMapping("/jpa/{id}")
  public ResponseEntity<Product> findById(@PathVariable long id) {
    return ResponseEntity.ok(
        service.findById(id));

  }

  /**
   * findAll.
   *
   * @return products.
   */
  @GetMapping("/jdbc-template/{id}")
  public ResponseEntity<Product> findById2(@PathVariable long id) {
    return ResponseEntity.ok(
        jdbcService.findById(id));
  }

  /**
   * findAll.
   *
   * @return products.
   */
  @GetMapping("/row-jdbc/{id}")
  public ResponseEntity<Product> findById3(@PathVariable long id) {
    return ResponseEntity.ok(
        connService.findById(id));
  }
}
