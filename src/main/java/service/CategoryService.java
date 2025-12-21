package com.example.demo.service;

import java.util.List;
import com.example.demo.model.Category;

public interface CategoryService {
    Category save(Category category);
    List<Category> findAll();
}
