package com.example.btlappmuasambe.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Category_Id")
    private Category category;

    private String name;

    private String linkImage;

    private double rating;

    private boolean favorite;

    private Long price;

    private int discount;

    //Số lượng nhập kho
    private int inventoryQuantity;

    //Số lượng tồn kho
    private int warehouseQuantity;

    //Số lượng đã bán
    private int soldQuantity;

    private Timestamp productImportDate;
}
