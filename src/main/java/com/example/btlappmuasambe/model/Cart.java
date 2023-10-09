package com.example.btlappmuasambe.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Cart {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "User_id")
    private Users user;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Product_id")
    private Product product;

    private int quantity;
}
