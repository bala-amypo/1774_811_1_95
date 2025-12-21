package com.example.demo.controller;

import com.example.demo.model.BudgetSummary;
import com.example.demo.repository.BudgetSummaryRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/summary")
public class BudgetSummaryController {

    private final BudgetSummaryRepository repo;

    public BudgetSummaryController(BudgetSummaryRepository repo) {
        this.repo = repo;
    }

    @PostMapping
    public BudgetSummary create(@RequestBody BudgetSummary summary) {
        return repo.save(summary);
    }

    @GetMapping
    public List<BudgetSummary> getAll() {
        return repo.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repo.deleteById(id);
    }
}
