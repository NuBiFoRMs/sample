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

        String token = sampleService.login(account);
        String message = sampleService.sayHello(token);

        System.out.println(message);
    }

    @Test
    public void signUp() {
        Account account = new Account();
        account.setUsername("nubiform");
        account.setPassword("Se1rv@er387");

        sampleService.signUp(account);
    }

}