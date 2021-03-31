package com.nubiform.springdatajpa.repository;

import com.nubiform.springdatajpa.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<Owner, Integer> {
}
