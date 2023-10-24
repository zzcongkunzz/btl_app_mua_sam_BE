package com.example.btlappmuasambe.service.implement;

import com.example.btlappmuasambe.model.Category;
import com.example.btlappmuasambe.model.response.GetCategoryResponse;
import com.example.btlappmuasambe.repository.CategoryRepository;
import com.example.btlappmuasambe.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public GetCategoryResponse getCategory() {
        GetCategoryResponse getCategoryResponse = new GetCategoryResponse();
        List<Category> listCategory = categoryRepository.findAll();
        getCategoryResponse.setListCategory(listCategory);
        return getCategoryResponse;
    }
}
