package com.example.btlappmuasambe.model.request;

import com.example.btlappmuasambe.model.Cart;
import com.example.btlappmuasambe.model.Product;
import com.example.btlappmuasambe.model.Users;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class AddCartRequest {
    private Users user;

    private Product product;

    private int quantity;
}
