package com.example.demo.interceptor;

public interface SessionNames {
    static final String LOGIN = "loginUser";
    static final String LOGIN_COOKIE = "loginCookie";
    static final String ATTEMPED_PATH = "attempted-path";
    static final Integer EXPIRE = 60 * 60 * 24 * 7;
}
