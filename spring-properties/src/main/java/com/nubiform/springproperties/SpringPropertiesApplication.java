package com.nubiform.springproperties;

import com.nubiform.springproperties.config.ItemProperties;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@AllArgsConstructor
@SpringBootApplication
public class SpringPropertiesApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringPropertiesApplication.class, args);
    }

    private final ItemProperties itemProperties;

    @Override
    public void run(String... args) throws Exception {
        log.info("{}", itemProperties.getItem().size());
    }
}
