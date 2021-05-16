package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public interface ValidationMessages {
    public static final String Required = "필수 항목";
    public static final String Format = "올바르지 않은 형식입니다!";
}
