package com.example.demo.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.demo.model.DemoUserModel;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor, SessionNames {

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {

        HandlerMethod method = (HandlerMethod) handler;
        System.out.println("\n\n MMMM>> Bean: " + method.getBean() + ", Method: " + method.getMethod() + "\n\n");
        System.out.println("\n\n MMMM>> Model: " + modelAndView + "\n\n");

        HttpSession session = request.getSession();

        DemoUserModel user = (DemoUserModel) modelAndView.getModelMap().get("user");
        System.out.println("\n\n LoginInterceptor.post>>" + user + "\n\n");

        if (user != null) {
            session.setAttribute(LOGIN, user);

            Cookie loginCookie = new Cookie(LOGIN_COOKIE, session.getId());
            loginCookie.setPath("/");
            loginCookie.setMaxAge(EXPIRE);

            response.addCookie(loginCookie);

            String attempted = (String) session.getAttribute(ATTEMPED_PATH);
            if (StringUtils.isNotEmpty(attempted)) {
                response.sendRedirect(attempted);
                session.removeAttribute(ATTEMPED_PATH);
            } else {
                response.sendRedirect("/board");
            }

        }

    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        System.out.println("LoginInterceptor.pre>>");

        HttpSession session = request.getSession();

        if (session.getAttribute(LOGIN) != null) {
            session.removeAttribute(LOGIN);
        }

        return true;

    }

}
