package com.example.demo.model;

import java.time.LocalDateTime;

public class BudgetSummary {

    public static final String STATUS_UNDER_LIMIT = "UNDER_LIMIT";
    public static final String STATUS_OVER_LIMIT = "OVER_LIMIT";

    private BudgetPlan budgetPlan;
    private String status;
    private LocalDateTime generatedAt;

    public BudgetSummary() {
        this.generatedAt = LocalDateTime.now();
    }

    public BudgetPlan getBudgetPlan() { return budgetPlan; }
    public void setBudgetPlan(BudgetPlan budgetPlan) {
        this.budgetPlan = budgetPlan;
    }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public LocalDateTime getGeneratedAt() { return generatedAt; }
}
