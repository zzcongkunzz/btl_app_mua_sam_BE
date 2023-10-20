package com.example.btlappmuasambe.model.request;

import com.example.btlappmuasambe.model.Users;
import lombok.Data;

@Data
public class RegisterRequest {
    private String fullName;

    private String password;

    private String email;

    private String phoneNumber;
}
