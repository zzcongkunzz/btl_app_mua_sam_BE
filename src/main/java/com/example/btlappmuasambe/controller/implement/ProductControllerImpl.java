package com.example.btlappmuasambe.controller.implement;

import com.example.btlappmuasambe.controller.ProductController;
import com.example.btlappmuasambe.model.Product;
import com.example.btlappmuasambe.model.request.FindProductByCriteriaRequest;
import com.example.btlappmuasambe.model.response.FindProductByCriteriaResponse;
import com.example.btlappmuasambe.model.response.GetProductResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductControllerImpl implements ProductController {
    @Override
    public GetProductResponse getProduct() {
        return new GetProductResponse();
    }

    @Override
    public Product findProductById(Long id) {
        return null;
    }

    @Override
    public FindProductByCriteriaResponse findProductByCriteria(FindProductByCriteriaRequest request) {
        return null;
    }
}
