package com.example.demo.vo;

import lombok.Data;

@Data
public class RegisterVo {
    private String email;
    private String name;
    private String password;

    public RegisterVo(String email, String name, String password) {
        this.email = email;
        this.name = name;
        this.password = password;
    }

}
