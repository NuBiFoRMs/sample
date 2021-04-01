package com.nubiform.springdatajpa.repository;

import com.nubiform.springdatajpa.model.Owner;
import com.nubiform.springdatajpa.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
