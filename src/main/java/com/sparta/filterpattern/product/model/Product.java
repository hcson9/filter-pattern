package com.sparta.filterpattern.product.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

/**
 * create on 2024/05/16 create by IntelliJ IDEA.
 *
 * <p> New Project. </p>
 *
 * @author HoChan Son (hcson)
 * @version 1.0
 * @since 1.0
 */
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Product {

  /**
   * id.
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  /**
   * 이름.
   */
  @Column(length = 100, nullable = false)
  private String name;

  /**
   * 가격.
   */
  @Column
  private Double price;

  /**
   * 카테고리.
   */
  @Column
  @Enumerated(EnumType.STRING)
  private Category category;

  /**
   * 품절유무.
   */
  @Column
  @Enumerated(EnumType.STRING)
  private YN soldYn;

  /**
   * 생성일.
   */
  @CreationTimestamp
  @Column(nullable = false, updatable = false)
  private LocalDateTime createdAt;


  /**
   * 생성자.
   *
   * @param name 이름
   * @param price 가격
   * @param category 카테고리
   * @param soldYn 품절유무
   */
  public Product(String name, Double price, Category category, YN soldYn) {
    this.name = name;
    this.price = price;
    this.category = category;
    this.soldYn = soldYn;
  }

  public Product(Long id, String name, Double price, Category category, YN soldYn,
      LocalDateTime createdAt) {
    this.id = id;
    this.name = name;
    this.price = price;
    this.category = category;
    this.soldYn = soldYn;
    this.createdAt = createdAt;
  }
}
