package com.nubiform.starter.sample;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import java.io.IOException;
import java.util.stream.Collectors;

@Slf4j
public class RequestParameterLoggingFilter implements Filter {

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
        log.debug(params);
    }
}
