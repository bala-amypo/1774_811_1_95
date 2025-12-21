package com.example.demo.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.model.BudgetPlan;
import com.example.demo.repository.BudgetPlanRepository;
import com.example.demo.service.BudgetPlanService;

@Service
public class BudgetPlanServiceImpl implements BudgetPlanService {

    private final BudgetPlanRepository repository;

    public BudgetPlanServiceImpl(BudgetPlanRepository repository) {
        this.repository = repository;
    }

    @Override
    public BudgetPlan save(BudgetPlan plan) {
        return repository.save(plan);
    }

    @Override
    public List<BudgetPlan> findAll() {
        return repository.findAll();
    }
}
