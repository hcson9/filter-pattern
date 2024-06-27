package com.sparta.filterpattern.product.model;

import org.apache.catalina.util.StringUtil;
import org.springframework.util.StringUtils;

/**
 * create on 2024/05/16 create by IntelliJ IDEA.
 *
 * <p> New Project. </p>
 *
 * @author HoChan Son (hcson)
 * @version 1.0
 * @since 1.0
 */
public enum Category {
  PANTS,
  SHIRTS,
  SOCKS,
  ACCESSORY,
  SHOES;

  public static Category getByString(String string) {
    for (Category category : Category.values()) {
      if (StringUtils.hasText(string) && string.equalsIgnoreCase(category.toString())) {
        return category;
      }
    }
    throw new IllegalArgumentException("Category not found");
  }
}
