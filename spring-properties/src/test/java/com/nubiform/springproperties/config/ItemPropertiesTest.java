package com.nubiform.springproperties.config;

import org.junit.jupiter.api.Test;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@EnableConfigurationProperties(ItemProperties.class)
class ItemPropertiesTest {

    @Resource
    ItemProperties itemProperties;

    @Test
    void test() {
        assertEquals("aa", itemProperties.getItem().get("name"));
    }

}
