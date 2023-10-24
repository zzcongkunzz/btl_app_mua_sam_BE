package com.example.btlappmuasambe.service;

import com.example.btlappmuasambe.model.Product;
import com.example.btlappmuasambe.model.request.FindProductByCriteriaRequest;
import com.example.btlappmuasambe.model.response.FindProductByCriteriaResponse;

import java.sql.Date;

public interface ProductService {
    Product addProduct (String name, String linkImage, double rating, boolean favorite, long price, int discount, int inventoryQuantity, String categoryName);

    Product addProductTest (String name, String linkImage, double rating, boolean favorite, long price, int discount, int inventoryQuantity, int soldQuantity, String productImportDate, String categoryName);

    FindProductByCriteriaResponse findProductByCriteria(FindProductByCriteriaRequest request);

    Product findProductById(Long id);

}
