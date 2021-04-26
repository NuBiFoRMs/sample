package com.nubiform.login.service;

import com.nubiform.login.domain.Account;
import com.nubiform.login.jwt.TokenProvider;
import com.nubiform.login.repository.AccountRepository;
import com.nubiform.login.request.LoginRequest;
import com.nubiform.login.request.SignUpRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Service
@Transactional
public class AccountService {

    private final AccountRepository accountRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    private final TokenProvider tokenProvider;

    public String login(LoginRequest loginRequest) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword());
        Authentication authentication = authenticationManager.authenticate(authenticationToken);

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = tokenProvider.createToken(authentication);

        log.debug("success login: {}", token);

        return token;
    }

    public Account signUp(SignUpRequest signUpRequest) {
        Account account = new Account();
        account.setUsername(signUpRequest.getUsername());
        account.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));

        return accountRepository.save(account);
    }
}
