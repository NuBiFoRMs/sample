package com.nubiform.rest.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.nubiform.rest.vo.Account;

@Slf4j
@RequiredArgsConstructor
@Service
public class SampleService {

    public static final String LOGIN_URL = "http://localhost:8080/login";
    public static final String HELLO_URL = "http://localhost:8080/";

    private final RestTemplate restTemplate;

    public String getToken(Account account) {
        RequestEntity<Account> requestEntity = RequestEntity
                .method(HttpMethod.POST, LOGIN_URL)
                .body(account);
        log.debug("requestEntity: {}", requestEntity);

        ResponseEntity<String> responseEntity = restTemplate.exchange(requestEntity, String.class);
        log.debug("responseEntity: {}", responseEntity);
        return responseEntity.getBody();
    }

    public String getHello(String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(token);
        headers.setContentType(MediaType.APPLICATION_JSON);
        RequestEntity requestEntity = RequestEntity
                .method(HttpMethod.GET, HELLO_URL)
                .headers(headers)
                .build();
        log.debug("requestEntity: {}", requestEntity);

        ResponseEntity<String> responseEntity = restTemplate.exchange(requestEntity, String.class);
        log.debug("responseEntity: {}", responseEntity);
        return responseEntity.getBody();
    }
}
