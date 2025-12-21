package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class BudgetSummary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double totalIncome;
    private Double totalExpense;
    private String status;

    @OneToOne
    private BudgetPlan budgetPlan;

    public BudgetSummary() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Double getTotalIncome() { return totalIncome; }
    public void setTotalIncome(Double totalIncome) { this.totalIncome = totalIncome; }

    public Double getTotalExpense() { return totalExpense; }
    public void setTotalExpense(Double totalExpense) { this.totalExpense = totalExpense; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public BudgetPlan getBudgetPlan() { return budgetPlan; }
    public void setBudgetPlan(BudgetPlan budgetPlan) { this.budgetPlan = budgetPlan; }
}
