package com.sparta.filterpattern.product.model;

/**
 * create on 2024/05/16 create by IntelliJ IDEA.
 *
 * <p> New Project. </p>
 *
 * @author HoChan Son (hcson)
 * @version 1.0
 * @since 1.0
 */
public enum YN {
  Y, N;



  public static YN getByString(String value) {
    for (YN yn : YN.values()) {
      if (yn.toString().equals(value)) {
        return yn;
      }
    }
    throw new IllegalArgumentException("yn not found");
  }
}
