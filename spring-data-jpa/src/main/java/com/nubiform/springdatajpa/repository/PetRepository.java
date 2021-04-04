package com.nubiform.springdatajpa.repository;

import com.nubiform.springdatajpa.repository.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PetRepository extends JpaRepository<Pet, Integer> {
    Optional<Pet> findByName(String name);
}
