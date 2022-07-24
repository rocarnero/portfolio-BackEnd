package com.carnerorociobelen.portfolio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carnerorociobelen.portfolio.interfaces.IPersonaService;
import com.carnerorociobelen.portfolio.model.Persona;
import com.carnerorociobelen.portfolio.repository.PersonaRepository;

@Service
public class PersonaService implements IPersonaService {
  @Autowired
  private PersonaRepository persoRepository;

  @Override
  public List<Persona> getPersonas() {
    return persoRepository.findAll();
  }
}
