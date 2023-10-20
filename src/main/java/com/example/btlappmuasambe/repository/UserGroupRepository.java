package com.example.btlappmuasambe.repository;

import com.example.btlappmuasambe.model.UserGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface UserGroupRepository extends JpaRepository<UserGroup, Long> {
    UserGroup findUserGroupByName(String name);
}
