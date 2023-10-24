package com.example.btlappmuasambe.service.implement;

import com.example.btlappmuasambe.consts.RoleType;
import com.example.btlappmuasambe.model.UserGroup;
import com.example.btlappmuasambe.model.Users;
import com.example.btlappmuasambe.model.response.LoginResponse;
import com.example.btlappmuasambe.model.response.RegisterResponse;
import com.example.btlappmuasambe.model.response.UpdateUserInformationResponse;
import com.example.btlappmuasambe.repository.UserGroupRepository;
import com.example.btlappmuasambe.repository.UserRepository;
import com.example.btlappmuasambe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserGroupRepository userGroupRepository;

    @Override
    public LoginResponse login(String phoneNumber, String password) {
        LoginResponse loginResponse = new LoginResponse();
        Users users =  userRepository.findByPhoneNumberAndPassword(phoneNumber, password);
        loginResponse.setUsers(users);
        return loginResponse;
    }

    @Override
    public RegisterResponse register(Users userRequest) {
        RegisterResponse registerResponse = new RegisterResponse();

        if(userRequest.getUserGroup() == null){
            UserGroup userGroup = userGroupRepository.findUserGroupByName(RoleType.KHACH_HANG.getValue());
            userRequest.setUserGroup(userGroup);
        }

        Users userResponse = userRepository.save(userRequest);
        registerResponse.setUsers(userResponse);
        return registerResponse;
    }

    @Override
    public UpdateUserInformationResponse updateUserInformation(Users users) {
        UpdateUserInformationResponse updateUserInformationResponse = new UpdateUserInformationResponse();
        updateUserInformationResponse.setUsers(userRepository.save(users));
        return updateUserInformationResponse;
    }
}
