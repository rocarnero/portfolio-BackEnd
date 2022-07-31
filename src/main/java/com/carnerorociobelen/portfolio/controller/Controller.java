package com.carnerorociobelen.portfolio.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.carnerorociobelen.portfolio.dto.UserDTO;
import com.carnerorociobelen.portfolio.interfaces.IUserService;
import com.carnerorociobelen.portfolio.model.AuthUser;
import com.carnerorociobelen.portfolio.model.User;
import com.carnerorociobelen.portfolio.repository.UserRepository;

@RestController
public class Controller {

  @Autowired
  private IUserService interUser;

  @GetMapping("/{slug}")
  public Optional<User> getUserBySlug(@PathVariable String slug){
    return interUser.getUserBySlug(slug);
  }

  @PutMapping("/{slug}")
  public Optional<User> editUserBySlug(@PathVariable String slug, @RequestBody User usr){
    return interUser.updateUserBySlug(slug, usr);
  }

  @PostMapping("/login")
  public Optional<User> editUserBySlug(@RequestBody AuthUser usr){
    return interUser.getUserByCredentials(usr);
  }

  @Bean
  public WebMvcConfigurer corsConfigurer() {
    return new WebMvcConfigurer() {
      @Override
      public void addCorsMappings(CorsRegistry registry) {
              registry.addMapping("/**")
                      .allowedOrigins("*")
                      .allowedMethods("GET", "POST", "PUT", "DELETE")
                      .maxAge(3600);
      }
    };
  }  
}
