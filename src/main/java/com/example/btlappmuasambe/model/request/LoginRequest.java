package com.example.btlappmuasambe.model.request;

import lombok.Data;

@Data
public class LoginRequest {
    private String phoneNumber;

    private String password;
}
