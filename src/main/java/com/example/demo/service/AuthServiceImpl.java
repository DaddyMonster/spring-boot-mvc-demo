package com.example.demo.service;

import com.example.demo.dto.LoginDto;
import com.example.demo.dto.RegisterDto;
import com.example.demo.mapper.DemoUserMapper;
import com.example.demo.model.AuthErrorModel;
import com.example.demo.model.DemoUserModel;
import com.example.demo.vo.LoginUserVo;
import com.example.demo.vo.RegisterVo;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private DemoUserMapper mapper;

    @Override
    public LoginUserVo LoginUser(LoginDto dto) {
        try {
            DemoUserModel user = mapper.findUserOneByEmail(dto.getEmail());
            System.out.println("\n\n");
            System.out.println(user);
            System.out.println("\n\n");
            if (user == null) {
                String reason = "email";
                String message = "존재하지 않는 유저";
                AuthErrorModel error = new AuthErrorModel(reason, message);
                return new LoginUserVo(error);
            }
            if (decryptPassword(dto.getPassword(), user.getPassword()) == false) {
                String reason = "password";
                String message = "비밀번호가 일치하지 않습니다.";
                AuthErrorModel error = new AuthErrorModel(reason, message);
                return new LoginUserVo(error);
            }
            return new LoginUserVo(user);
        } catch (Exception e) {
            System.out.println("Exception" + e);
            return null;
        }
    }

    @Override
    public AuthErrorModel RegisterUser(RegisterDto dto) {

        try {
            String email = dto.getEmail();
            String name = dto.getName();
            String password = BCrypt.hashpw(dto.getPassword(), BCrypt.gensalt());
            RegisterVo userVo = new RegisterVo(email, name, password);
            System.out.println(userVo + "\n\n" + password);
            mapper.registerUser(userVo);
            return null;
        } catch (Exception e) {
            System.out.println(e);
            return null;
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

    private boolean decryptPassword(String inputPassword, String hashedPassword) {
        return BCrypt.checkpw(inputPassword, hashedPassword);
    }
}
