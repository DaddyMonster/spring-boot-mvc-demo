package com.example.demo.service;

import com.example.demo.dto.LoginDto;
import com.example.demo.dto.RegisterDto;
import com.example.demo.model.DemoUserModel;

public interface AuthService {
    public DemoUserModel LoginUser(LoginDto dto);

    public boolean RegisterUser(RegisterDto dto);

    public boolean UpdatePassword(int uid, String newPassword);

    public boolean DeleteUser(int uid);

}
