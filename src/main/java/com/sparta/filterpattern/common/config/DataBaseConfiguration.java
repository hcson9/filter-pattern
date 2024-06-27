package com.sparta.filterpattern.common.config;

import com.sparta.filterpattern.product.repository.ProductRowJdbcRepository;
import com.sparta.filterpattern.product.repository.ProductJdbcTemplateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * create on 2024/06/13 create by IntelliJ IDEA.
 *
 * <p> New Project. </p>
 *
 * @author HoChan Son (hcson)
 * @version 1.0
 * @since 1.0
 */
@Configuration
public class DataBaseConfiguration {

  @Bean
  public ProductJdbcTemplateRepository productJdbcRepository(@Autowired JdbcTemplate jdbcTemplate) {
    return new ProductJdbcTemplateRepository(jdbcTemplate);
  }


  @Bean
  public ProductRowJdbcRepository productConnectRepository(
      @Value("${spring.datasource.url}") String url,
      @Value("${spring.datasource.username}") String user,
      @Value("${spring.datasource.password}") String password,
      @Value("${spring.datasource.driver-class-name}") String driverClassName) {
    return new ProductRowJdbcRepository(url, user, password, driverClassName);
  }

}
