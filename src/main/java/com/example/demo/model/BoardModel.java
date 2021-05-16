package com.example.demo.model;

import java.util.Date;

import lombok.Data;

@Data
public class BoardModel {
    private int id;
    private String title;
    private String description;
    private Date createdAt;
    private Date updatedAt;
    private DemoUserModel issuer;
    private int issuerId;
}
