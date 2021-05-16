package com.example.demo.service;

import com.example.demo.dto.LoginDto;
import com.example.demo.dto.RegisterDto;
import com.example.demo.model.AuthErrorModel;
import com.example.demo.vo.LoginUserVo;

public interface AuthService {
    public LoginUserVo LoginUser(LoginDto dto) throws Exception;

    public AuthErrorModel RegisterUser(RegisterDto dto) throws Exception;

    public boolean UpdatePassword(int uid, String newPassword) throws Exception;

    public boolean DeleteUser(int uid) throws Exception;

}
