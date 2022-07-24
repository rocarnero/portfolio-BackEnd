package com.carnerorociobelen.portfolio.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class User {
  public Long id;
  public String name;

  public User(Long id, String name) {
    this.id = id;
    this.name = name;
  }
}
