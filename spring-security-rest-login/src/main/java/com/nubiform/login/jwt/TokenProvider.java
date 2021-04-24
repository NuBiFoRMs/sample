package com.nubiform.login.jwt;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TokenProvider implements InitializingBean {

    private final String secret;
    private final long tokenValidityInMillisecond;

    public TokenProvider(@Value("${jwt.secret}") String secret, @Value("${jwt.token-validity-in-second}") long tokenValidityInSecond) {
        log.debug("TokenProvider");
        this.secret = secret;
        this.tokenValidityInMillisecond = tokenValidityInSecond * 1000;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.debug("afterPropertiesSet");
    }
}
