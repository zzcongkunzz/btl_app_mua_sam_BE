package com.example.btlappmuasambe.model.response;

import com.example.btlappmuasambe.model.Product;
import lombok.Data;

import java.util.ArrayList;

@Data
public class GetProductResponse {
    private ArrayList<Product> productArrayList;
}
