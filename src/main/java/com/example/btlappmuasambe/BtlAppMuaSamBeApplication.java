package com.example.btlappmuasambe;

import com.example.btlappmuasambe.consts.RoleType;
import com.example.btlappmuasambe.model.UserGroup;
import com.example.btlappmuasambe.model.Users;
import com.example.btlappmuasambe.repository.UserGroupRepository;
import com.example.btlappmuasambe.repository.UserRepository;
import com.example.btlappmuasambe.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.HashSet;
import java.util.Optional;

@SpringBootApplication
public class BtlAppMuaSamBeApplication {

    public static void main(String[] args) {
        SpringApplication.run(BtlAppMuaSamBeApplication.class, args);
    }

    @Bean
    CommandLineRunner run(UserGroupRepository userGroupRepository, UserService userService){
        return args -> {
            UserGroup userGroupNV = userGroupRepository.save(new UserGroup(RoleType.NHAN_VIEN.getValue()));
            UserGroup userGroupAdmin = userGroupRepository.save(new UserGroup( RoleType.Admin.getValue()));
            UserGroup userGroupKH = userGroupRepository.save(new UserGroup( RoleType.KHACH_HANG.getValue()));

//            //Thêm User
//            Users users = new Users();
//            users.setUserGroup(userGroupNV);
//            users.setFullName("Đặng Thành Công");
//            users.setPhoneNumber("0914133719");
//            users.setPassword("1");
//            userService.register(users);
        };
    }

}
