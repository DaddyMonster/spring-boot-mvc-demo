package com.example.demo.configs;

import com.example.demo.interceptor.AuthInterceptor;
import com.example.demo.interceptor.LoginInterceptor;
import com.example.demo.interceptor.SessionInterceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new SessionInterceptor()).addPathPatterns("/**");
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/login-submit");
        registry.addInterceptor(new AuthInterceptor()).addPathPatterns("/board/write");

    }

}
