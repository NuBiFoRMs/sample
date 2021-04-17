package com.nubiform.login.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Data
public class AccountDto {
    @NotBlank
    @Length(min = 4, max = 20)
    String username;
    @NotBlank
    @Length(min = 4, max = 20)
    String password;
}
