package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.model.BudgetPlan;
import com.example.demo.model.User;
import com.example.demo.repository.BudgetPlanRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.BudgetPlanService;

public class BudgetPlanServiceImpl implements BudgetPlanService {

    private final BudgetPlanRepository repo;
    private final UserRepository userRepo;

    public BudgetPlanServiceImpl(BudgetPlanRepository repo, UserRepository userRepo) {
        this.repo = repo;
        this.userRepo = userRepo;
    }

    @Override
    public BudgetPlan createBudgetPlan(Long userId, BudgetPlan plan) {
        User user = userRepo.findById(userId).orElseThrow();
        plan.setUser(user);
        plan.validate();

        if (repo.findByUserAndMonthAndYear(user, plan.getMonth(), plan.getYear()).isPresent()) {
            throw new BadRequestException("Plan already exists");
        }
        return repo.save(plan);
    }

    @Override
    public BudgetPlan getBudgetPlan(Long userId, Integer month, Integer year) {
        User user = userRepo.findById(userId).orElseThrow();
        return repo.findByUserAndMonthAndYear(user, month, year).orElseThrow();
    }
}
