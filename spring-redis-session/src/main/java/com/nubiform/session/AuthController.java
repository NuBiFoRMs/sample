package com.nubiform.session;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.session.Session;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@Slf4j
@RestController
public class AuthController {

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginRequest loginRequest, HttpSession session) {
        log.info("username: {} password: {}" ,loginRequest.getUsername(), loginRequest.getPassword());
        session.setAttribute("username", loginRequest.getUsername());
        return ResponseEntity.ok().build();
    }
}
