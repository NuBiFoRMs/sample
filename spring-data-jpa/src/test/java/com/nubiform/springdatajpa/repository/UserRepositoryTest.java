package com.nubiform.springdatajpa.repository;

import com.nubiform.springdatajpa.model.User;
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
class UserRepositoryTest {

    public static final int INIT_SIZE = 1;
    public static final String NAME = "name";
    @Autowired
    UserRepository userRepository;

    @BeforeEach
    void setUp() {
        User user = User.builder()
                .name("name")
                .password("password")
                .email("email")
                .enabled(true)
                .build();
        userRepository.save(user);
    }

    @AfterEach
    void tearDown() {
        userRepository.deleteAll();
    }

    @Test
    public void findAllTest() {
        List<User> users = userRepository.findAll();

        assertNotNull(users);
        assertEquals(INIT_SIZE, users.size());
    }

    @Test
    public void findByNameTest() {
        Optional<User> user = userRepository.findByName(NAME);

        assertTrue(user.isPresent());
        assertEquals(NAME, user.get().getName());
    }
}