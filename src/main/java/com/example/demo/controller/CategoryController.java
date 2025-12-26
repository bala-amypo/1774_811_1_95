package com.example.demo.controller;

import com.example.demo.model.Category;
import com.example.demo.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService service;

    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @PostMapping
    public Category create(@RequestBody Category c) {
        return service.addCategory(c);
    }

    @GetMapping
    public List<Category> list() {
        return service.getAllCategories();
    }
}
