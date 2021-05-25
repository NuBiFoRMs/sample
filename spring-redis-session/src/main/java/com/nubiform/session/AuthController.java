package com.nubiform.session;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@Slf4j
@RequiredArgsConstructor
@RestController
public class AuthController {

    private final RedisTemplate redisTemplate;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginRequest loginRequest, HttpSession session) {
        log.info("username: {} password: {}" ,loginRequest.getUsername(), loginRequest.getPassword());
        session.setAttribute("username", loginRequest.getUsername());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/info")
    public ResponseEntity<String> info(HttpSession session) {
        String username = (String) session.getAttribute("username");
        return ResponseEntity.ok(username);
    }

    @PostMapping("/redis")
    public ResponseEntity redis(@RequestBody LoginRequest loginRequest) {
        redisTemplate.opsForValue().set(loginRequest.getUsername(), loginRequest);
        return ResponseEntity.ok().build();
    }
}
