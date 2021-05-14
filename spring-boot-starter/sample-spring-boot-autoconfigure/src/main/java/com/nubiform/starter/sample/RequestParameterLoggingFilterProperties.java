package com.nubiform.starter.sample;

import lombok.Getter;
import lombok.Setter;
import org.slf4j.event.Level;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = "spring.mvc.request-parameter-logging-filter")
public class RequestParameterLoggingFilterProperties {

    private boolean enabled;

    private Level level;
}
