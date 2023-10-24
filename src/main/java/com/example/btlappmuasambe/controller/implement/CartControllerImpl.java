package com.example.btlappmuasambe.controller.implement;

import com.example.btlappmuasambe.controller.CartController;
import com.example.btlappmuasambe.model.Product;
import com.example.btlappmuasambe.model.request.AddCartRequest;
import com.example.btlappmuasambe.model.request.GetCartByUserRequest;
import com.example.btlappmuasambe.model.request.UpdateCartRequest;
import com.example.btlappmuasambe.model.response.AddCartResponse;
import com.example.btlappmuasambe.model.response.GetCartByUserResponse;
import com.example.btlappmuasambe.model.response.UpdateCartResponse;
import com.example.btlappmuasambe.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartControllerImpl implements CartController {
    @Autowired
    private CartService cartService;

    @Override
    public GetCartByUserResponse getCartByUser(GetCartByUserRequest request) {
        return cartService.getCartByUser(request);
    }

    @Override
    public AddCartResponse addCart(AddCartRequest request) {
        return cartService.addCart(request);
    }

    @Override
    public UpdateCartResponse updateCart(UpdateCartRequest request) {
        return cartService.updateCart(request);
    }

    @Override
    public void deleteCartById(Long id) {
        cartService.deleteCart(id);
    }
}
