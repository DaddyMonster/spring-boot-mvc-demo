package com.example.demo.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class DemoUserModel implements Serializable {
    private Integer id;
    private String email;
    private String name;
    private String password;
}
