package com.example.btlappmuasambe.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class OrderDtails {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Oder_Id")
    private Oder oder;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Product_id")
    private Product product;

    private int quantity;

    private Long price;

    private int discount;

    private Long intoMoney;
}
