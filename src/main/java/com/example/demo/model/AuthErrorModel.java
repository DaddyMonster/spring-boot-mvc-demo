package com.example.demo.model;

import lombok.Data;

@Data
public class AuthErrorModel {
    private String reason;
    private String message;

    public AuthErrorModel(String reason, String message) {
        this.reason = reason;
        this.message = message;
    }

}
