package com.carnerorociobelen.portfolio.repository;

import org.springframework.stereotype.Repository;

import com.carnerorociobelen.portfolio.dto.UserDTO;
import com.carnerorociobelen.portfolio.model.User;

@Repository
public class UserRepository {

  public UserDTO getUser(){
    User user = new User(1L, "Carnero");
    UserDTO userDTO = new UserDTO();
    
    userDTO.setId_user(user.getId());
    userDTO.setName(user.getName());

    return userDTO;
    
  }
  
}
