package com.example.demo.controller;

import com.example.demo.model.TransactionLog;
import com.example.demo.repository.TransactionRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
@Tag(name = "Transaction CRUD")
public class TransactionController {

    private final TransactionRepository repo;

    public TransactionController(TransactionRepository repo) {
        this.repo = repo;
    }

    @PostMapping
    public TransactionLog create(@RequestBody TransactionLog log) {
        return repo.save(log);
    }

    @GetMapping
    public List<TransactionLog> getAll() {
        return repo.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repo.deleteById(id);
    }
}
