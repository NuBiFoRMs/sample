package com.nubiform.login;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Base64;

@Slf4j
@SpringBootApplication
public class App implements CommandLineRunner {

    @Value("${jwt.secret}")
    private String secret;

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.debug("{}", new String(Base64.getDecoder().decode(secret)));
    }
}
