package com.example.btlappmuasambe.repository;

import com.example.btlappmuasambe.model.Cart;
import com.example.btlappmuasambe.model.Product;
import com.example.btlappmuasambe.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Long> {
    List<Cart> findCartsByUser(Users users);
    Cart findCartsByUserAndProduct(Users users, Product product);
}
