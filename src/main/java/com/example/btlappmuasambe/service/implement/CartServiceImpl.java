package com.example.btlappmuasambe.service.implement;

import com.example.btlappmuasambe.model.Cart;
import com.example.btlappmuasambe.model.request.AddCartRequest;
import com.example.btlappmuasambe.model.request.DeleteCartRequest;
import com.example.btlappmuasambe.model.request.GetCartByUserRequest;
import com.example.btlappmuasambe.model.request.UpdateCartRequest;
import com.example.btlappmuasambe.model.response.AddCartResponse;
import com.example.btlappmuasambe.model.response.DeleteCartResponse;
import com.example.btlappmuasambe.model.response.GetCartByUserResponse;
import com.example.btlappmuasambe.model.response.UpdateCartResponse;
import com.example.btlappmuasambe.repository.CartRepository;
import com.example.btlappmuasambe.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartRepository cartRepository;

    @Override
    public GetCartByUserResponse getCartByUser(GetCartByUserRequest request) {
        List<Cart> listCart = cartRepository.findCartsByUser(request.getUser());
        GetCartByUserResponse getCartByUserResponse = new GetCartByUserResponse();
        getCartByUserResponse.setListCart(listCart);
        return getCartByUserResponse;
    }

    @Override
    public AddCartResponse addCart(AddCartRequest request) {
        Cart cart = cartRepository.findCartsByUserAndProduct(request.getUser(), request.getProduct());

        if(cart != null){
            cart.setQuantity(cart.getQuantity()  + request.getQuantity());
        }
        else {
            cart = new Cart();
            cart.setUser(request.getUser());
            cart.setProduct(request.getProduct());
            cart.setQuantity(request.getQuantity());
        }

        AddCartResponse addCartResponse = new AddCartResponse();
        addCartResponse.setCart(cartRepository.save(cart));
        return addCartResponse;
    }

    @Override
    public UpdateCartResponse updateCart(UpdateCartRequest request) {
        UpdateCartResponse updateCartResponse = new UpdateCartResponse();
        Cart cart = cartRepository.save(request.getCart());
        updateCartResponse.setCart(cart);
        return updateCartResponse;
    }

    @Override
    public void deleteCart(Long id) {
        DeleteCartResponse deleteCartResponse = new DeleteCartResponse();
        cartRepository.deleteById(id);
    }
}
