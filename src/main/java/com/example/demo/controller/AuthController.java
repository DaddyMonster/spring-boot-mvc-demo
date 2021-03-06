package com.example.demo.controller;

import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import com.example.demo.dto.LoginDto;
import com.example.demo.dto.RegisterDto;
import com.example.demo.interceptor.SessionNames;
import com.example.demo.model.AuthErrorModel;
import com.example.demo.service.AuthService;
import com.example.demo.vo.LoginUserVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.util.WebUtils;

@Controller
public class AuthController implements SessionNames {

    @Autowired
    private AuthService auth_srv;

    @GetMapping("/login")
    public String loginView(HttpSession session, HttpServletRequest request, HttpServletResponse response,
            Model model) {
        System.out.println(session.getAttribute(SessionNames.LOGIN));
        session.removeAttribute(SessionNames.LOGIN);
        session.invalidate();
        Cookie loginCookie = WebUtils.getCookie(request, SessionNames.LOGIN);

        if (loginCookie != null) {
            loginCookie.setPath("/");
            loginCookie.setMaxAge(0);
            response.addCookie(loginCookie);
        }

        model.addAttribute("loginDto", new LoginDto());

        return "login";
    }

    @PostMapping("/login-submit")
    public String handleSubmit(@Valid @ModelAttribute("loginDto") LoginDto dto, BindingResult bindingResult,
            Model model, HttpSession session) throws Exception {
        if (bindingResult.hasErrors()) {
            System.out.println(dto);
            System.out.println("Invalid!" + bindingResult.getAllErrors().toString());
            return "login";
        } else {
            try {
                LoginUserVo userVo = auth_srv.LoginUser(dto);
                if (userVo.getError() != null) {
                    AuthErrorModel voError = userVo.getError();
                    bindingResult.rejectValue(voError.getReason(), "loginDto." + voError.getReason(),
                            voError.getMessage());
                    return "login";
                }
                // ????????? ??????????????? ?????????!
                // ?????? ????????? ????????? ???????????? ??????????????? ????????? ????????? ?????????...(??????????????? ??????)?!
                // Session ??? ?????? ????????? ??????????????? ??????????????? ??????????
                model.addAttribute("user", userVo.getUser());
                return "board/index";

            } catch (Exception e) {
                return "error";
            }
        }
    }

    @GetMapping("/register")
    public String registerView(HttpSession session, HttpServletRequest request, HttpServletResponse response,
            Model model) {
        model.addAttribute("registerDto", new RegisterDto());

        return "register";
    }

    @PostMapping("/register-submit")
    public String registerSubmit(@Valid @ModelAttribute("registerDto") RegisterDto dto, BindingResult bindingResult,
            Model model, HttpSession session, HttpServletResponse response) {
        if (bindingResult.hasErrors()) {
            if (bindingResult.hasGlobalErrors()) {
                bindingResult.rejectValue("passwordCheck", "registerDto.passwordCheck",
                        bindingResult.getGlobalError().getDefaultMessage());
            }
            System.out.println(dto);
            System.out.println("Invalid!" + bindingResult.getGlobalErrors().toString());
            return "register";
        } else {
            try {
                AuthErrorModel registerTrial = auth_srv.RegisterUser(dto);
                if (registerTrial != null) {
                    bindingResult.rejectValue("email", "registerDto.email", "?????? ???????????? E-mail ?????????.");
                    return "register";
                }
                response.sendRedirect("/login");
                return null;

            } catch (Exception e) {
                return "error";
            }
        }

    }

    @GetMapping("logout")
    public String logout(HttpSession session, HttpServletResponse response) throws IOException {
        session.invalidate();
        Cookie loginCookie = new Cookie(LOGIN_COOKIE, session.getId());
        loginCookie.setPath("/");
        loginCookie.setMaxAge(0);
        response.addCookie(loginCookie);
        return "index";
    }

}
