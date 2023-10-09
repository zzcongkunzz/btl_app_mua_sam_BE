package com.example.btlappmuasambe.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Entity
public class Oder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "User_Id")
    private Users users;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Staff_Id")
    private Users staff;

    private String type;

    private Timestamp purchaseDate;

    private Timestamp receivedDate;

    private Long totalPrice;
}
