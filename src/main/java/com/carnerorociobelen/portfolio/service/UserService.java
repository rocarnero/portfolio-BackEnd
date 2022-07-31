package com.carnerorociobelen.portfolio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.carnerorociobelen.portfolio.interfaces.IUserService;
import com.carnerorociobelen.portfolio.model.AuthUser;
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

    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    User usr = uRepository.findById(1L).get();
    usr.setUsername("rocarnero");
    usr.setPassword(encoder.encode("12345678"));
    uRepository.save(usr);

    return uRepository.findOne(example);
  }

  @Override
  public Optional<User> updateUserBySlug(String slug, User usr) {
    Optional<User> savedUser = getUserBySlug(slug);
    if (savedUser.isPresent()) {
      usr.setId(savedUser.get().getId());
      return Optional.of(uRepository.save(usr));
    } else {
      return Optional.empty();
    }
  }

  @Override
  public Optional<User> getUserByCredentials(AuthUser usr) {
    ExampleMatcher customExampleMatcher = ExampleMatcher.matchingAny()
    .withMatcher("username", ExampleMatcher.GenericPropertyMatchers.exact());

    User user = new User();
    user.setUsername(usr.getUsername());
    Example<User> example = Example.of(user, customExampleMatcher);

    Optional<User> savedUser = uRepository.findOne(example);
    if (savedUser.isPresent()) {
      BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
      if (encoder.matches(usr.getPassword(), savedUser.get().getPassword())) {
        return savedUser;
      } else {
        return Optional.empty();
      }
    } else {
      return Optional.empty();
    }

  }
}
