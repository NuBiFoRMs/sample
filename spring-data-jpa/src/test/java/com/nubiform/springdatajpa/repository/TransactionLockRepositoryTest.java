package com.nubiform.springdatajpa.repository;

import com.nubiform.springdatajpa.repository.entity.TransactionLock;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@Transactional
@SpringBootTest
class TransactionLockRepositoryTest {

    @Autowired
    TransactionLockRepository transactionLockRepository;

    @Test
    public void test() {
        TransactionLock test = transactionLockRepository.findWithLockNameForUpdate("test").orElse(null);
    }
}