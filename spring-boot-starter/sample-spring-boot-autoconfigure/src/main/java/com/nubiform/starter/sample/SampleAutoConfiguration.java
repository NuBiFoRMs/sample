package com.nubiform.starter.sample;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;

@Slf4j
@RequiredArgsConstructor
@Configuration
@AutoConfigureAfter(WebMvcAutoConfiguration.class)
@EnableConfigurationProperties(RequestParameterLoggingFilterProperties.class)
public class SampleAutoConfiguration {

    private final RequestParameterLoggingFilterProperties requestParameterLoggingFilterProperties;

    @Bean
    @ConditionalOnProperty(name = "spring.mvc.request-parameter-logging-filter.enabled", havingValue = "true")
    public Filter requestParameterLoggingFilter() {
        log.info("Bean registry requestParameterLoggingFilter: {}, {}", requestParameterLoggingFilterProperties.isEnabled(), requestParameterLoggingFilterProperties.getLevel());
        return new RequestParameterLoggingFilter(requestParameterLoggingFilterProperties.getLevel());
    }
}
