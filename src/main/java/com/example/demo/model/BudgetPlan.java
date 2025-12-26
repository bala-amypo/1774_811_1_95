package com.example.demo.model;

public class BudgetPlan {

    private Long id;
    private User user;
    private int month;
    private int year;
    private double totalIncome;
    private double totalExpense;

    public BudgetPlan() {}

    public BudgetPlan(Long id, User user, int month, int year,
                      double totalIncome, double totalExpense) {
        this.id = id;
        this.user = user;
        this.month = month;
        this.year = year;
        this.totalIncome = totalIncome;
        this.totalExpense = totalExpense;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public User getUser() { return user; }
}
