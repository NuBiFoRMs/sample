package com.nubiform.login.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nubiform.login.domain.Account;
import com.nubiform.login.repository.AccountRepository;
import com.nubiform.login.request.LoginRequest;
import com.nubiform.login.request.SignUpRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class AccountControllerTest {

    public static final String USERNAME = "username";
    public static final String PASSWORD = "Pass@word1";

    @Autowired
    MockMvc mockMvc;

    @Autowired
    AccountRepository accountRepository;

    @Test
    void hello() throws Exception {
        mockMvc.perform(get("/"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void login() throws Exception {
        LoginRequest accountDto = new LoginRequest();
        accountDto.setUsername(USERNAME);
        accountDto.setPassword(PASSWORD);

        ObjectMapper objectMapper = new ObjectMapper();

        mockMvc.perform(post("/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(accountDto)))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void signUp() throws Exception {
        SignUpRequest accountDto = new SignUpRequest();
        accountDto.setUsername(USERNAME);
        accountDto.setPassword(PASSWORD);

        ObjectMapper objectMapper = new ObjectMapper();

        mockMvc.perform(post("/sign-up")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(accountDto)))
                .andDo(print())
                .andExpect(status().isOk());

        Account account = accountRepository.findByUsername("username").orElse(null);
        assertNotNull(account);
        assertEquals(USERNAME, account.getUsername());
    }
}