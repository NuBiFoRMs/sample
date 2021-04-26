package com.nubiform.login.jwt;

import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

@Slf4j
@Component
public class TokenProvider implements InitializingBean {

    public static final String AUTHORITIES_KEY = "auth";
    public static final String DELIMITER = ",";

    private final String secret;
    private final long tokenValidityInMillisecond;

    private Key key;

    public TokenProvider(@Value("${jwt.secret}") String secret,
                         @Value("${jwt.token-validity-in-second}") long tokenValidityInSecond) {
        log.debug("TokenProvider");
        this.secret = secret;
        this.tokenValidityInMillisecond = tokenValidityInSecond * 1000;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.debug("afterPropertiesSet");
        this.key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(secret));
    }

    public String createToken(Authentication authentication) {
        String authorities = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(DELIMITER));

        Date now = new Date();

        return Jwts.builder()
                .signWith(key, SignatureAlgorithm.HS512)
                .setSubject(authentication.getName())
                .claim(AUTHORITIES_KEY, authorities)
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + tokenValidityInMillisecond))
                .compact();
    }

    public Authentication getAuthentication(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();

        Collection<? extends GrantedAuthority> authorities = Arrays.stream(claims.get(AUTHORITIES_KEY).toString().split(DELIMITER))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());

        User principal = new User(claims.getSubject(), "", authorities);

        return new UsernamePasswordAuthenticationToken(principal, token, authorities);
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
        } catch (ExpiredJwtException e) {
            log.info("만료된 JWT 토큰 입니다.");
        } catch (UnsupportedJwtException e) {
            log.info("지원되지 않는 JWT 토큰 입니다.");
        } catch (MalformedJwtException e) {
            log.info("잘못된 JWT 토큰 입니다.");
        } catch (SignatureException e) {
            log.info("잘못된 JWT 서명 입니다.");
        } catch (IllegalArgumentException e) {
            log.info("잘못된 토큰 입니다.");
        }
        return false;
    }
}
