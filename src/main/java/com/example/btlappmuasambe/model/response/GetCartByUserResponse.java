package com.example.btlappmuasambe.model.response;

import com.example.btlappmuasambe.model.Cart;
import lombok.Data;

import java.util.List;

@Data
public class GetCartByUserResponse {
    private List<Cart> listCart;
}
