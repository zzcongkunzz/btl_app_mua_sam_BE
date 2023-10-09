package com.example.btlappmuasambe.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Uses")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UserGrop_Id")
    private UserGroup userGroup;

    private String fullName;

    private String userName;

    private String password;

    private String email;

    private String phoneNumber;

    private String gender;

    private String address;

}
