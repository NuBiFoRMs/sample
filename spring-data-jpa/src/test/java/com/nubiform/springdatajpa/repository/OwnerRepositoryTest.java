package com.nubiform.springdatajpa.repository;

import com.nubiform.springdatajpa.model.Owner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class OwnerRepositoryTest {

    public static final int INIT_SIZE = 1;
    public static final int INVALID_ID = 0;

    @Autowired
    OwnerRepository ownerRepository;

    @BeforeEach
    void setUp() {
        Owner owner = Owner.builder()
                .firstName("firstName")
                .lastName("lastName")
                .address("address")
                .city("city")
                .telephone("telephone")
                .build();
        ownerRepository.save(owner);
    }

    @AfterEach
    void tearDown() {
        ownerRepository.deleteAll();
    }

    @Test
    public void findAllTest() {
        List<Owner> owners = ownerRepository.findAll();

        assertNotNull(owners);
        assertEquals(INIT_SIZE, owners.size());
    }

    @Test
    public void findByIdTest() {
        Integer id = ownerRepository.findAll().get(0).getId();

        Optional<Owner> resultOwner = ownerRepository.findById(id);

        assertTrue(resultOwner.isPresent());
        assertEquals(id, resultOwner.get().getId());
    }

    @Test
    public void findByIdNullTest() {
        Optional<Owner> owner = ownerRepository.findById(INVALID_ID);

        assertTrue(owner.isEmpty());
    }

    @Test
    public void saveTest() {
        Owner owner = Owner.builder()
                .firstName("firstName")
                .lastName("lastName")
                .address("address")
                .city("city")
                .telephone("telephone")
                .build();
        ownerRepository.save(owner);

        List<Owner> afterOwners = ownerRepository.findAll();

        assertEquals(INIT_SIZE + 1, afterOwners.size());
    }
}