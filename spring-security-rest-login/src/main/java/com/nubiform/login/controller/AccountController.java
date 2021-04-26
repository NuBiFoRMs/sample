package com.nubiform.login.controller;

import com.nubiform.login.config.CurrentUser;
import com.nubiform.login.domain.Account;
import com.nubiform.login.request.LoginRequest;
import com.nubiform.login.request.SignUpRequest;
import com.nubiform.login.service.AccountService;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
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
@RequiredArgsConstructor
@SecurityScheme(type = SecuritySchemeType.HTTP, scheme = "Bearer", bearerFormat = "JWT", name = "Authorization", in = SecuritySchemeIn.HEADER)
@RestController
public class AccountController {

    private final AccountService accountService;

    @SecurityRequirement(name = "Authorization")
    @GetMapping("/")
    public ResponseEntity<String> hello(@CurrentUser Account account) {
        if (account == null)
            return new ResponseEntity<>("Hello World", HttpStatus.OK);

        return new ResponseEntity<>("Hello World " + account.getUsername(), HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        log.debug("username: {} password: {}", loginRequest.getUsername(), loginRequest.getPassword());

        return new ResponseEntity<>(accountService.login(loginRequest), HttpStatus.OK);
    }

    @PostMapping("/sign-up")
    public ResponseEntity<?> signUp(@Valid @RequestBody SignUpRequest signUpRequest, Errors errors) {
        log.debug("username: {} password: {}", signUpRequest.getUsername(), signUpRequest.getPassword());
        if (errors.hasErrors()) {
            String errorMessage = errors.getAllErrors().stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.joining(", ", "[", "]"));
            log.debug("errorMessage: {}", errorMessage);

            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        accountService.signUp(signUpRequest);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
