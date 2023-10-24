package com.example.btlappmuasambe.controller.implement;

import com.example.btlappmuasambe.controller.CategoryController;
import com.example.btlappmuasambe.model.Product;
import com.example.btlappmuasambe.model.response.GetCategoryResponse;
import com.example.btlappmuasambe.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryControllerImpl implements CategoryController {
    @Autowired
    private CategoryService categoryService;

    @Override
    public GetCategoryResponse getCategory() {
        return categoryService.getCategory();
    }
}
