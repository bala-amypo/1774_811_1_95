package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Category;
import com.example.demo.repository.CategoryRepository;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryRepository repository;

    public CategoryController(CategoryRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/create")
    public Category create(@RequestBody Category category) {
        return repository.save(category);
    }

    @GetMapping("/all")
    public List<Category> getAll() {
        return repository.findAll();
    }
}
