package com.example.demo.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.model.TransactionLog;
import com.example.demo.repository.TransactionLogRepository;
import com.example.demo.service.TransactionLogService;

@Service
public class TransactionLogServiceImpl implements TransactionLogService {

    private final TransactionLogRepository repository;

    public TransactionLogServiceImpl(TransactionLogRepository repository) {
        this.repository = repository;
    }

    @Override
    public TransactionLog save(TransactionLog transaction) {
        return repository.save(transaction);
    }

    @Override
    public List<TransactionLog> findAll() {
        return repository.findAll();
    }
}
