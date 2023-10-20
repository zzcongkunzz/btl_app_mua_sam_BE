package com.example.btlappmuasambe.controller.implement;

import com.example.btlappmuasambe.controller.AuthController;
import com.example.btlappmuasambe.model.request.LoginRequest;
import com.example.btlappmuasambe.model.response.LoginResponse;
import com.example.btlappmuasambe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthControllerImpl implements AuthController {
    @Autowired
    private UserService userService;

    @Override
    public LoginResponse postLogin(LoginRequest request) {

        return userService.login(request.getPhoneNumber(), request.getPassword());
    }
}
