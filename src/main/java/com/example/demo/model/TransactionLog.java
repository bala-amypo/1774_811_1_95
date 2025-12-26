package com.example.demo.model;

import java.time.LocalDate;

public class TransactionLog {

    private Long id;
    private double amount;
    private LocalDate transactionDate;
    private User user;
    private Category category;

    public TransactionLog() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }

    public LocalDate getTransactionDate() { return transactionDate; }
    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public Category getCategory() { return category; }
    public void setCategory(Category category) {
        this.category = category;
    }
}
