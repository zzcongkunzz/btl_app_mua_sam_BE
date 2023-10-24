package com.example.btlappmuasambe.controller.implement;

import com.example.btlappmuasambe.controller.ProductController;
import com.example.btlappmuasambe.model.Product;
import com.example.btlappmuasambe.model.request.FindProductByCriteriaRequest;
import com.example.btlappmuasambe.model.response.FindProductByCriteriaResponse;
import com.example.btlappmuasambe.model.response.GetProductResponse;
import com.example.btlappmuasambe.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductControllerImpl implements ProductController {
    @Autowired
    private ProductService productService;

    @Override
    public Product findProductById(Long id) {
        return productService.findProductById(id);
    }

    @Override
    public FindProductByCriteriaResponse findProductByCriteria(FindProductByCriteriaRequest request) {
        return productService.findProductByCriteria(request);
    }
}
