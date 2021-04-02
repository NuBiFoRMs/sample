package com.nubiform.springdatajpa.repository;

import com.nubiform.springdatajpa.repository.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet, Integer> {

}
