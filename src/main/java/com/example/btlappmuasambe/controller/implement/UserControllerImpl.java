package com.example.btlappmuasambe.controller.implement;

import com.example.btlappmuasambe.controller.UserController;
import com.example.btlappmuasambe.model.Users;
import com.example.btlappmuasambe.model.request.RegisterRequest;
import com.example.btlappmuasambe.model.request.UpdateUserInformationRequest;
import com.example.btlappmuasambe.model.response.RegisterResponse;
import com.example.btlappmuasambe.model.response.UpdateUserInformationResponse;
import com.example.btlappmuasambe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserControllerImpl implements UserController {
    @Autowired
    private UserService userService;

    @Override
    public RegisterResponse register(RegisterRequest request) {
        Users users = new Users();

        users.setFullName(request.getFullName());
        users.setPassword(request.getPassword());
        users.setPhoneNumber(request.getPhoneNumber());
        users.setEmail(request.getEmail());

        return userService.register(users);
    }

    @Override
    public UpdateUserInformationResponse updateUserInformation(UpdateUserInformationRequest request) {
        return userService.updateUserInformation(request.getUsers());
    }
}
