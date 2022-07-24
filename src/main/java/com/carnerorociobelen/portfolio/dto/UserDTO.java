package com.carnerorociobelen.portfolio.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserDTO implements Serializable{
  private Long id_user;
  private String name;
}
