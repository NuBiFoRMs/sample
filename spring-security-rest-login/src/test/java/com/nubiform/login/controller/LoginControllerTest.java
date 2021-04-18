package com.nubiform.login.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nubiform.login.request.LoginRequest;
import com.nubiform.login.request.SignUpRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class LoginControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void login() throws Exception {
        LoginRequest accountDto = new LoginRequest();
        accountDto.setUsername("username");
        accountDto.setPassword("password");

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
        accountDto.setUsername("username");
        accountDto.setPassword("Pass@word1");

        ObjectMapper objectMapper = new ObjectMapper();

        mockMvc.perform(post("/sign-up")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(accountDto)))
                .andDo(print())
                .andExpect(status().isOk());
    }
}