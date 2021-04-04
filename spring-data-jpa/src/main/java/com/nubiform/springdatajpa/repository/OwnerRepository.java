package com.nubiform.springdatajpa.repository;

import com.nubiform.springdatajpa.repository.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OwnerRepository extends JpaRepository<Owner, Integer> {
    Optional<Owner> findByFirstNameAndLastName(String firstName, String lastName);
}
