package com.nubiform.starter.sample;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.logging.LogLevel;

import javax.servlet.*;
import java.io.IOException;
import java.util.stream.Collectors;

@Slf4j
public class RequestParameterLoggingFilter implements Filter {

    private final LogLevel level;

    public RequestParameterLoggingFilter(LogLevel level) {
        this.level = level;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String params = servletRequest.getParameterMap()
                .entrySet()
                .stream()
                .map(entry -> entry.getKey() + "=" + String.join(",", entry.getValue()))
                .collect(Collectors.joining("&"));
        log(params);
        filterChain.doFilter(servletRequest, servletResponse);
    }

    private void log(String params) {
        if (params == null || "".equals(params)) return;

        switch (level) {
            case INFO:
                log.info(params);
                break;
            case DEBUG:
                log.debug(params);
                break;
        }
    }
}
