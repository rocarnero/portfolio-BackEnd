package com.carnerorociobelen.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.carnerorociobelen.portfolio.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
  
}
