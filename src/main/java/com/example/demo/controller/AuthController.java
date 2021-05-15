package com.example.demo.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import com.example.demo.dto.LoginDto;
import com.example.demo.interceptor.SessionNames;
import com.example.demo.model.DemoUserModel;
import com.example.demo.service.AuthService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.util.WebUtils;

@Controller
public class AuthController {

    @Autowired
    private AuthService auth_srv;

    @GetMapping("/login")
    public String loginPage(HttpSession session, HttpServletRequest request, HttpServletResponse response,
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
            HttpSession session) throws Exception {
        if (bindingResult.hasErrors()) {
            System.out.println(dto);
            System.out.println("Invalid!" + bindingResult.getAllErrors().toString());
            return "login";
        } else {
            try {
                System.out.println("\n \nUSER DTO: ");
                System.out.println(dto);
                DemoUserModel user = auth_srv.LoginUser(dto);
                System.out.println("\n \nUSER : ");
                System.out.println(user);
                if (user != null) {
                    return "redirect:/board";
                }
                return "login";
            } catch (Exception e) {
                return "error";
            }
        }
    }

}
