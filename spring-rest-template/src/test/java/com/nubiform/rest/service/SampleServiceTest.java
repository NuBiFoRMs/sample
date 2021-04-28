package com.nubiform.rest.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.nubiform.rest.vo.Account;

@SpringBootTest
class SampleServiceTest {

    @Autowired
    SampleService sampleService;

    @Test
    public void test() {
        Account account = new Account();
        account.setUsername("nubiform");
        account.setPassword("Se1rv@er387");

        String token = sampleService.getToken(account);
        String message = sampleService.getHello(token);

        System.out.println(message);
    }

}