package com.nubiform.springdatajpa.repository;

import com.nubiform.springdatajpa.repository.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<Owner, Integer> {
}
