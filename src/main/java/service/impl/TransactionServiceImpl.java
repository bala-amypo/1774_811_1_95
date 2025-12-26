package com.example.demo.service.impl;

import com.example.demo.model.TransactionLog;
import com.example.demo.model.User;
import com.example.demo.repository.TransactionLogRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.TransactionService;

import java.util.List;

public class TransactionServiceImpl implements TransactionService {

    private final TransactionLogRepository repo;
    private final UserRepository userRepo;

    public TransactionServiceImpl(TransactionLogRepository repo, UserRepository userRepo) {
        this.repo = repo;
        this.userRepo = userRepo;
    }

    @Override
    public TransactionLog addTransaction(Long userId, TransactionLog log) {
        User user = userRepo.findById(userId).orElseThrow();
        log.setUser(user);
        log.validate();
        return repo.save(log);
    }

    @Override
    public List<TransactionLog> getUserTransactions(Long userId) {
        User user = userRepo.findById(userId).orElseThrow();
        return repo.findByUser(user);
    }
}
