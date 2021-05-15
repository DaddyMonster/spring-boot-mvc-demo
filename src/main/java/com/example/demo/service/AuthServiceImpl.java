package com.example.demo.service;

import com.example.demo.dto.LoginDto;
import com.example.demo.dto.RegisterDto;
import com.example.demo.mapper.DemoUserMapper;
import com.example.demo.model.DemoUserModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private DemoUserMapper mapper;

    @Override
    public DemoUserModel LoginUser(LoginDto dto) {
        DemoUserModel user = mapper.findUserOneByEmail(dto.getEmail());
        return user;
    }

    @Override
    public boolean RegisterUser(RegisterDto dto) {
        try {
            mapper.registerUser(dto);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    @Override
    public boolean UpdatePassword(int uid, String newPassword) {
        try {
            mapper.updatePassword(uid, newPassword);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    @Override
    public boolean DeleteUser(int uid) {
        try {
            mapper.deleteUser(uid);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

}
