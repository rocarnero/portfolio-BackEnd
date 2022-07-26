package com.carnerorociobelen.portfolio.interfaces;

import java.util.List;
import java.util.Optional;

import com.carnerorociobelen.portfolio.model.AuthUser;
import com.carnerorociobelen.portfolio.model.User;

public interface IUserService {
  public Optional<User> getUserBySlug(String slug);
  public Optional<User> updateUserBySlug(String slug, User usr);
  public Optional<User> getUserByCredentials(AuthUser usr);
}
