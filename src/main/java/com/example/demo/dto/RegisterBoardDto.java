package com.example.demo.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.example.demo.service.ValidationMessages;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor()
public class RegisterBoardDto {

    @NotNull(message = ValidationMessages.Required)
    @Size(min = 5, max = 128, message = "5자 이상 , 128자 이하로 작성!")
    private String title;

    @NotNull(message = ValidationMessages.Required)
    @Size(min = 10, max = 1024, message = "10자 이상 , 1024자 이하로 작성!")
    private String description;
}
