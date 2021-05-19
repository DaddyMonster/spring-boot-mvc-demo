package com.example.demo.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.demo.model.DemoUserModel;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class SessionInterceptor implements HandlerInterceptor, SessionNames {
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {

        HttpSession session = request.getSession();
        DemoUserModel user = (DemoUserModel) session.getAttribute(LOGIN);

        if (user != null && modelAndView != null) {
            modelAndView.addObject("user", user);
        }
    }

}
