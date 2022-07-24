package com.carnerorociobelen.portfolio.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.carnerorociobelen.portfolio.dto.UserDTO;
import com.carnerorociobelen.portfolio.interfaces.IPersonaService;
import com.carnerorociobelen.portfolio.model.Persona;
import com.carnerorociobelen.portfolio.model.User;
import com.carnerorociobelen.portfolio.repository.UserRepository;

@RestController
public class Controller {

  @Autowired
  private IPersonaService interPersona;

  @GetMapping("/personas")
  public List<Persona> getPersonas(){
    return interPersona.getPersonas();
  }
  
}
