package com.nubiform.spirngiocdi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App implements CommandLineRunner {
    private static final Logger log = LoggerFactory.getLogger(App.class);

    private final MyService myService;

    public App(MyService myService) {
        this.myService = myService;
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("start application");
        myService.sendNotification("This is a test message");
        log.info("end application");
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
