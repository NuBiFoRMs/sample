package com.nubiform.login.service;

import com.nubiform.login.domain.Account;
import com.nubiform.login.repository.AccountRepository;
import com.nubiform.login.request.LoginRequest;
import com.nubiform.login.request.SignUpRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Service
@Transactional
public class AccountService {

    private final AccountRepository accountRepository;

    public void login(LoginRequest loginRequest) {
    }

    public Account signUp(SignUpRequest signUpRequest) {
        Account account = new Account();
        account.setUsername(signUpRequest.getUsername());
        account.setPassword(signUpRequest.getPassword());

        return accountRepository.save(account);
    }
}
