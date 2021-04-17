package com.nubiform.login.controller;

import com.nubiform.login.dto.AccountDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.stream.Collectors;

@Slf4j
@RestController
public class LoginController {

    @GetMapping("/")
    public ResponseEntity<String> hello() {
        return new ResponseEntity<>("Hello World", HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody AccountDto accountDto) {
        log.debug("username: {} password: {}", accountDto.getUsername(), accountDto.getPassword());
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/sign-up")
    public ResponseEntity signUp(@Valid @RequestBody AccountDto accountDto, Errors errors) {
        log.debug("username: {} password: {}", accountDto.getUsername(), accountDto.getPassword());
        if (errors.hasErrors()) {
            String errorMessage = errors.getAllErrors().stream()
                    .map(e -> e.getDefaultMessage())
                    .collect(Collectors.joining(", ", "[", "]"));
            log.debug("errorMessage: {}", errorMessage);

            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(HttpStatus.OK);
    }
}
