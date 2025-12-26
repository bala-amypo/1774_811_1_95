package com.example.demo.controller;

import com.example.demo.model.BudgetPlan;
import com.example.demo.service.BudgetPlanService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/budgets")
public class BudgetPlanController {

    private final BudgetPlanService budgetPlanService;

    public BudgetPlanController(BudgetPlanService budgetPlanService) {
        this.budgetPlanService = budgetPlanService;
    }

    @PostMapping("/{userId}")
    public BudgetPlan createBudgetPlan(
            @PathVariable Long userId,
            @RequestBody BudgetPlan budgetPlan) {

        return budgetPlanService.createBudgetPlan(userId, budgetPlan);
    }

    @GetMapping("/{userId}/{month}/{year}")
    public BudgetPlan getBudgetPlan(
            @PathVariable Long userId,
            @PathVariable Integer month,
            @PathVariable Integer year) {

        return budgetPlanService.getBudgetPlan(userId, month, year);
    }
}
