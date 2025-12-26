package com.example.demo.controller;

import com.example.demo.model.TransactionLog;
import com.example.demo.service.TransactionService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/{userId}")
    public TransactionLog addTransaction(
            @PathVariable Long userId,
            @RequestBody TransactionLog transactionLog) {

        return transactionService.addTransaction(userId, transactionLog);
    }

    @GetMapping("/user/{userId}")
    public List<TransactionLog> getUserTransactions(@PathVariable Long userId) {
        return transactionService.getUserTransactions(userId);
    }
}
