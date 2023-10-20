package com.example.btlappmuasambe.repository;

import com.example.btlappmuasambe.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {
    Users findByPhoneNumberAndPassword(String phoneNumber, String password);
}
