package com.nubiform.login.service;

import com.nubiform.login.config.UserAccount;
import com.nubiform.login.domain.Account;
import com.nubiform.login.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@RequiredArgsConstructor
@Service
public class SecurityService implements UserDetailsService, LogoutSuccessHandler {

    private final AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.debug("loadUserByUsername: username: {}", username);

        Account account = accountRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));

        return new UserAccount(account);
    }

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        if (authentication == null) {
            log.debug("logout: null");

            response.setStatus(HttpStatus.BAD_REQUEST.value());
        }
        else {
            UserAccount userAccount = (UserAccount) authentication.getPrincipal();
            Account account = userAccount.getAccount();
            log.debug("logout: {}", account.getUsername());

            response.setStatus(HttpStatus.OK.value());
        }
    }
}
