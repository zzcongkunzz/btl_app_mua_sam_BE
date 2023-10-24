package com.example.btlappmuasambe.service;

import com.example.btlappmuasambe.model.Cart;
import com.example.btlappmuasambe.model.Users;
import com.example.btlappmuasambe.model.request.AddCartRequest;
import com.example.btlappmuasambe.model.request.DeleteCartRequest;
import com.example.btlappmuasambe.model.request.GetCartByUserRequest;
import com.example.btlappmuasambe.model.request.UpdateCartRequest;
import com.example.btlappmuasambe.model.response.AddCartResponse;
import com.example.btlappmuasambe.model.response.DeleteCartResponse;
import com.example.btlappmuasambe.model.response.GetCartByUserResponse;
import com.example.btlappmuasambe.model.response.UpdateCartResponse;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CartService {
    GetCartByUserResponse getCartByUser(GetCartByUserRequest request);

    AddCartResponse addCart(AddCartRequest request);

    UpdateCartResponse updateCart(UpdateCartRequest request);

    void deleteCart(Long request);


}
