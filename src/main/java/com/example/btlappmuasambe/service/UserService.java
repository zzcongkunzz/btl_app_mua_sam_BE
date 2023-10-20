package com.example.btlappmuasambe.service;

import com.example.btlappmuasambe.model.Users;
import com.example.btlappmuasambe.model.response.LoginResponse;
import com.example.btlappmuasambe.model.response.RegisterResponse;
import com.example.btlappmuasambe.model.response.UpdateUserInformationResponse;

public interface UserService {
    LoginResponse login(String phoneNumber, String password);

    RegisterResponse register(Users users);

    UpdateUserInformationResponse updateUserInformation(Users users);

}
