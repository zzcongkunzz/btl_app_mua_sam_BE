package com.example.btlappmuasambe.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "Uses")
@NoArgsConstructor
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "UserGrop_Id")
    private UserGroup userGroup;

    private String fullName;

    private String password;

    private String email;

    private String phoneNumber;

    private String gender;

    private String address;

    public Users(UserGroup userGroup, String fullName, String password, String email, String phoneNumber, String gender, String address) {
        this.userGroup = userGroup;
        this.fullName = fullName;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.address = address;
    }
}
