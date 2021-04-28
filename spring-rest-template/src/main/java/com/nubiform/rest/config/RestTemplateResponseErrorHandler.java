package com.nubiform.rest.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.IOException;

@Slf4j
public class RestTemplateResponseErrorHandler implements ResponseErrorHandler {
    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {
        log.debug("RestTemplateResponseErrorHandler: hasError: {}", response.getStatusCode());
        return false;
    }

    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
        log.debug("RestTemplateResponseErrorHandler: handleError");
    }
}
