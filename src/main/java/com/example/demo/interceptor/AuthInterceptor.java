package com.example.demo.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

public class AuthInterceptor implements HandlerInterceptor, SessionNames {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        HttpSession session = request.getSession();
        System.out.println("\n\n" + "AUTH INTERCEPTOR PER HANDLER" + "\n\n");

        Cookie loginCookie = new Cookie(LOGIN_COOKIE, session.getId());
        loginCookie.setPath("/");
        loginCookie.setMaxAge(EXPIRE);

        response.addCookie(loginCookie);

        return session.getAttribute(LOGIN) != null;
    }

}
