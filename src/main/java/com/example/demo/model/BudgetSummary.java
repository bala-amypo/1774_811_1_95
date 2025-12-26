package com.example.demo.model;

import java.time.LocalDateTime;

public class BudgetSummary {

    public static final String STATUS_UNDER_LIMIT = "UNDER_LIMIT";
    public static final String STATUS_OVER_LIMIT = "OVER_LIMIT";

    // SERVICE EXPECTS THESE NAMES
    public static final String UNDER_LIMIT = "UNDER_LIMIT";
    public static final String OVER_LIMIT = "OVER_LIMIT";

    private BudgetPlan budgetPlan;
    private double totalIncome;
    private double totalExpense;
    private String status;
    private LocalDateTime generatedAt = LocalDateTime.now();

    public BudgetPlan getBudgetPlan() { return budgetPlan; }
    public void setBudgetPlan(BudgetPlan budgetPlan) {
        this.budgetPlan = budgetPlan;
    }

    public void setTotalIncome(double totalIncome) {
        this.totalIncome = totalIncome;
    }

    public void setTotalExpense(double totalExpense) {
        this.totalExpense = totalExpense;
    }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public LocalDateTime getGeneratedAt() { return generatedAt; }
}
