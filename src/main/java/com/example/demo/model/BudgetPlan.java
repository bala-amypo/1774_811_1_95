package com.example.demo.model;

public class BudgetPlan {

    private Long id;
    private User user;
    private int month;
    private int year;
    private double totalIncome;
    private double totalExpense;
    private double expenseLimit;

    public BudgetPlan() {}

    public BudgetPlan(Long id, User user, int month, int year,
                      double totalIncome, double totalExpense) {
        this.id = id;
        this.user = user;
        this.month = month;
        this.year = year;
        this.totalIncome = totalIncome;
        this.totalExpense = totalExpense;
        this.expenseLimit = totalExpense;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public int getMonth() { return month; }
    public int getYear() { return year; }

    public double getExpenseLimit() { return expenseLimit; }

    // REQUIRED BY SERVICE
    public void validate() {
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("Invalid month");
        }
        if (year <= 0) {
            throw new IllegalArgumentException("Invalid year");
        }
    }
}
