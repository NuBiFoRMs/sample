package com.nubiform.springproperties.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

@Data
@Component
@ConfigurationProperties(prefix = "myconfig")
public class ItemProperties {
    private Map<String, String> item;
}
