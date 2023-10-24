package com.example.btlappmuasambe.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Timestamp;

@Data
@Entity
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Category_Id")
    private Category category;

    @Column(columnDefinition = "nvarchar(max)")
    private String name;

    private String linkImage;

    private double rating;

    private boolean favorite;

    private long price;

    private int discount;

    //Số lượng nhập kho
    private int inventoryQuantity;

    //Số lượng tồn kho
    private int warehouseQuantity;

    //Số lượng đã bán
    private int soldQuantity;

    @Column(columnDefinition = "datetime")
    private Timestamp productImportDate;

    public Product(Category category, String name, String linkImage, double rating, boolean favorite, long price, int discount, int inventoryQuantity) {
        this.category = category;
        this.name = name;
        this.linkImage = linkImage;
        this.rating = rating;
        this.favorite = favorite;
        this.price = price;
        this.discount = discount;
        this.inventoryQuantity = inventoryQuantity;
    }
}
