package com.nubiform.login.service;

import com.nubiform.login.request.LoginRequest;
import com.nubiform.login.request.SignUpRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
public class AccountService {

    public void login(LoginRequest loginRequest) {
    }

    public void signUp(SignUpRequest signUpRequest) {
    }
}
