package com.example.btlappmuasambe.model.response;

import com.example.btlappmuasambe.model.Category;
import lombok.Data;

import java.util.List;

@Data
public class GetCategoryResponse {
    private List<Category> listCategory;
}
