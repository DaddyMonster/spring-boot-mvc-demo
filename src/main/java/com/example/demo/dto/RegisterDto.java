package com.example.demo.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.example.demo.service.ValidationMessages;
import com.example.demo.util.ExpAssert;

import lombok.Data;

@Data
@ExpAssert(value = "password == passwordCheck", message = "비밀번호가 다릅니다.")
public class RegisterDto {

    @Email(message = ValidationMessages.Format)
    @NotNull(message = ValidationMessages.Required)
    private String email;

    @NotNull(message = ValidationMessages.Required)
    @Size(min = 2, max = 16, message = "최소 2자 이상, 16자 이하로 입력하세요")
    private String name;

    @NotNull(message = ValidationMessages.Required)
    @Pattern(regexp = "^.*(?=^.{8,15}$)(?=.*)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$", message = "특수 문자를 1자 이상 포함하세요!")
    @Size(min = 8, max = 32, message = "최소 8자 이상, 32자 이하로 입력하세요")
    private String password;

    @Size(min = 2, max = 16, message = "최소 8자 이상, 32자 이하로 입력하세요")
    private String passwordCheck;

}
