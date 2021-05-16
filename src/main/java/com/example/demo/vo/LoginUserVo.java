package com.example.demo.vo;

import com.example.demo.model.AuthErrorModel;
import com.example.demo.model.DemoUserModel;

import lombok.Data;

@Data
public class LoginUserVo {
    private DemoUserModel user;
    private AuthErrorModel error;

    public LoginUserVo(DemoUserModel user) {
        this.user = user;
    }

    public LoginUserVo(AuthErrorModel error) {
        this.error = error;
    }

}
