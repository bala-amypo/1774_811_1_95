package com.example.demo.service;

import java.util.List;
import com.example.demo.model.BudgetPlan;

public interface BudgetPlanService {
    BudgetPlan save(BudgetPlan plan);
    List<BudgetPlan> findAll();
}
