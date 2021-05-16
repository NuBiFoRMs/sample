package com.nubiform.starter.sample;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.servlet.Filter;

@Slf4j
@RequiredArgsConstructor
@PropertySource("classpath:/META-INF/request-parameter-logging-filter.properties")
@Configuration
@AutoConfigureAfter(WebMvcAutoConfiguration.class)
@EnableConfigurationProperties(RequestParameterLoggingFilterProperties.class)
public class SampleAutoConfiguration {

    private final RequestParameterLoggingFilterProperties requestParameterLoggingFilterProperties;

    @Bean
    @ConditionalOnProperty(name = "spring.mvc.request-parameter-logging-filter.enabled", havingValue = "true")
    public Filter requestParameterLoggingFilter() {
        log.info("RequestParameterLoggingFilter Bean registry enabled: {} level: {}", requestParameterLoggingFilterProperties.isEnabled(), requestParameterLoggingFilterProperties.getLevel());
        return new RequestParameterLoggingFilter(requestParameterLoggingFilterProperties.getLevel());
    }
}
