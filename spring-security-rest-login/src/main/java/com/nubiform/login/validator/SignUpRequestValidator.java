package com.nubiform.login.validator;

import com.nubiform.login.repository.AccountRepository;
import com.nubiform.login.request.SignUpRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@RequiredArgsConstructor
@Component
public class SignUpRequestValidator implements Validator {

    private final AccountRepository accountRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(SignUpRequest.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        SignUpRequest signUpRequest = (SignUpRequest) target;

        if (accountRepository.existsByUsername(signUpRequest.getUsername())) {
            errors.rejectValue("username", "invalid.username", new Object[]{signUpRequest.getUsername()}, "이미 사용중인 유저네임입니다.");
        }
    }
}
