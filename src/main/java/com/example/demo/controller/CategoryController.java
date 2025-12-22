package com.example.demo.controller;

import com.example.demo.model.Category;
import com.example.demo.repository.CategoryRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
@Tag(name = "Category CRUD")
public class CategoryController {

    private final CategoryRepository repo;

    public CategoryController(CategoryRepository repo) {
        this.repo = repo;
    }

    @PostMapping
    public Category create(@RequestBody Category category) {
        return repo.save(category);
    }

    @GetMapping
    public List<Category> getAll() {
        return repo.findAll();
    }

    @PutMapping("/{id}")
    public Category update(@PathVariable Long id, @RequestBody Category category) {
        category.setId(id);
        return repo.save(category);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repo.deleteById(id);
    }
}
