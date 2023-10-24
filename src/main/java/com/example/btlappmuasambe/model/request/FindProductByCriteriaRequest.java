package com.example.btlappmuasambe.model.request;

import lombok.Data;

import java.util.ArrayList;

@Data
public class FindProductByCriteriaRequest {
    private String nameProductOrCategory;
    private ArrayList<String> category;
    private String sortBy;
}
