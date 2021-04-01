package com.nubiform.springdatajpa.repository;

import com.nubiform.springdatajpa.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepositoryTest {
    @Autowired
    UserRepository userRepository;

    @Test
    public void findAllTest() {
        List<User> users = userRepository.findAll();

        assertNotNull(users);
    }

    @Test
    public void test() {

    }
}