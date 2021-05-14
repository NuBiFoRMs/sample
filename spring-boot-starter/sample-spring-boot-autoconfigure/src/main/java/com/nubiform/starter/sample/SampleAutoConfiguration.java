package com.nubiform.starter.sample;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;

@RequiredArgsConstructor
@Configuration
@AutoConfigureAfter(WebMvcAutoConfiguration.class)
@EnableConfigurationProperties(RequestParameterLoggingFilterProperties.class)
public class SampleAutoConfiguration {

    private final RequestParameterLoggingFilterProperties requestParameterLoggingFilterProperties;

    @Bean
    @ConditionalOnProperty(name = "spring.mvc.request-parameter-logging-filter.enabled", havingValue = "true")
    public Filter requestParameterLoggingFilter() {
        return new RequestParameterLoggingFilter();
    }
}
