package com.example.demo.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class LoginDto {
    @NotNull(message = "필수 입력 항목")
    @Email(message = "Non valid email")
    private String email;

    @Size(min = 8, message = "8자 이상")
    @NotNull(message = "필수 항목")
    private String password;
}
