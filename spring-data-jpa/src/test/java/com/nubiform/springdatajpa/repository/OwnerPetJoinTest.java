package com.nubiform.springdatajpa.repository;

import com.nubiform.springdatajpa.repository.entity.Owner;
import com.nubiform.springdatajpa.repository.entity.Pet;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
class OwnerPetJoinTest {

    @Autowired
    OwnerRepository ownerRepository;

    @Autowired
    PetRepository petRepository;

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {

    }

    @Test
    @Transactional
    public void joinTest1() {
        List<Owner> owners = ownerRepository.findAll();

        Owner owner = owners.get(0);
        Pet pet = owner.getPets().get(0);

        System.out.println(owner.getFirstName());
        System.out.println(pet.getName());
    }

    @Test
    public void joinTest2() {
        List<Pet> pets = petRepository.findAll();

        Pet pet = pets.get(0);
        Owner owner = pet.getOwner();

        System.out.println(pet.getName());
        System.out.println(owner.getFirstName());
    }
}