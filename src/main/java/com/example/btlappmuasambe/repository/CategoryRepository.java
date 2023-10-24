package com.example.btlappmuasambe.repository;

import com.example.btlappmuasambe.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findCategoriesByName(String name);
}
