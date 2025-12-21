package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class BudgetPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer month;
    private Integer year;
    private Double incomeTarget;
    private Double expenseLimit;

    @ManyToOne
    private User user;

    public BudgetPlan() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Integer getMonth() { return month; }
    public void setMonth(Integer month) { this.month = month; }

    public Integer getYear() { return year; }
    public void setYear(Integer year) { this.year = year; }

    public Double getIncomeTarget() { return incomeTarget; }
    public void setIncomeTarget(Double incomeTarget) { this.incomeTarget = incomeTarget; }

    public Double getExpenseLimit() { return expenseLimit; }
    public void setExpenseLimit(Double expenseLimit) { this.expenseLimit = expenseLimit; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
}
