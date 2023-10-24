package com.example.btlappmuasambe.model.response;

import com.example.btlappmuasambe.model.Product;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class FindProductByCriteriaResponse {
    private List<Product> listProduct;

}
