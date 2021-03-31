package com.nubiform.springdatajpa.repository;

import com.nubiform.springdatajpa.model.Owner;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OwnerRepositoryTest {

    @Autowired
    OwnerRepository ownerRepository;

    @Test
    public void findAllTest() {
        List<Owner> owners = ownerRepository.findAll();

        assertNotNull(owners);
    }

    @Test
    public void findByIdTest() {
        Optional<Owner> owner = ownerRepository.findById(1);

        assertTrue(owner.isPresent());
        assertEquals(1, owner.get().getId());
    }

    @Test
    public void findByIdNullTest() {
        Optional<Owner> owner = ownerRepository.findById(0);

        assertTrue(owner.isEmpty());
    }

    @Test
    public void saveTest() {
        List<Owner> beforeOwners = ownerRepository.findAll();

        Owner owner = Owner.builder()
                .firstName("firstName")
                .lastName("lastName")
                .address("address")
                .city("city")
                .telephone("telephone")
                .build();
        ownerRepository.save(owner);

        List<Owner> afterOwners = ownerRepository.findAll();

        assertEquals(beforeOwners.size() + 1, afterOwners.size());
    }
}