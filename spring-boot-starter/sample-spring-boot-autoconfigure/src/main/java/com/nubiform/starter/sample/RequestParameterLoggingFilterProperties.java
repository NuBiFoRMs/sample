package com.nubiform.starter.sample;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.logging.LogLevel;

@Getter
@Setter
@ConfigurationProperties(prefix = "spring.mvc.request-parameter-logging-filter")
public class RequestParameterLoggingFilterProperties {

    private boolean enabled = true;

    private LogLevel level = LogLevel.DEBUG;
}
