package com.nubiform.login.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

@Slf4j
@Component
public class TokenProvider implements InitializingBean {

    public static final String AUTHORITIES_KEY = "auth";
    private final String secret;
    private final long tokenValidityInMillisecond;

    public TokenProvider(@Value("${jwt.secret}") String secret,
                         @Value("${jwt.token-validity-in-second}") long tokenValidityInSecond) {
        log.debug("TokenProvider");
        this.secret = secret;
        this.tokenValidityInMillisecond = tokenValidityInSecond * 1000;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.debug("afterPropertiesSet");
    }

    public String getToken(Authentication authentication) {
        String authorities = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));

        Date now = new Date();

        return Jwts.builder()
                .setSubject(authentication.getName())
                .claim(AUTHORITIES_KEY, authorities)
                .signWith(SignatureAlgorithm.HS512, secret)
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + tokenValidityInMillisecond))
                .compact();
    }

    public Authentication getAuthentication(String token) {
        Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();

        Collection<? extends GrantedAuthority> authorities = Arrays.stream(claims.get(AUTHORITIES_KEY).toString().split(","))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());

        User principal = new User(claims.getSubject(), "", authorities);

        return new UsernamePasswordAuthenticationToken(principal, token, authorities);
    }

    public String parseToken(String token) {
        return Jwts.parser().setSigningKey(secret).parse(token).toString();
    }

    public boolean validateToken(String token) {
        return true;
    }
}
