package com.carnerorociobelen.portfolio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import com.carnerorociobelen.portfolio.interfaces.IUserService;
import com.carnerorociobelen.portfolio.model.User;
import com.carnerorociobelen.portfolio.repository.UserRepository;

@Service
public class UserService implements IUserService {
  @Autowired
  private UserRepository uRepository;

  @Override
  public Optional<User> getUserBySlug(String slug) {
    ExampleMatcher customExampleMatcher = ExampleMatcher.matchingAny()
    .withMatcher("slug", ExampleMatcher.GenericPropertyMatchers.exact());

    User user = new User();
    user.setSlug(slug);
    Example<User> example = Example.of(user, customExampleMatcher);

    /*User user2 = new User();
    user2.setAge(33);
    user2.setFirst_name("Cecilia");
    user2.setLast_name("Carnero");
    user2.setEmail("ceciliacarnero@gmail.com");
    user2.setSlug("cecilia-carnero");
    uRepository.save(user2);*/

    return uRepository.findOne(example);
  }
}
