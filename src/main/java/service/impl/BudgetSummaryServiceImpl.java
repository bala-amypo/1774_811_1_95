package com.example.demo.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.model.BudgetSummary;
import com.example.demo.repository.BudgetSummaryRepository;
import com.example.demo.service.BudgetSummaryService;

@Service
public class BudgetSummaryServiceImpl implements BudgetSummaryService {

    private final BudgetSummaryRepository repository;

    public BudgetSummaryServiceImpl(BudgetSummaryRepository repository) {
        this.repository = repository;
    }

    @Override
    public BudgetSummary save(BudgetSummary summary) {
        return repository.save(summary);
    }

    @Override
    public List<BudgetSummary> findAll() {
        return repository.findAll();
    }
}
