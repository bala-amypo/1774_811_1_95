package com.example.demo.model;

import com.example.demo.exception.BadRequestException;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class BudgetPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    private Integer month;
    private Integer year;
    private Double incomeTarget;
    private Double expenseLimit;

    public BudgetPlan() {}

    public void validate() {
        if (month < 1 || month > 12) {
            throw new BadRequestException("Invalid month");
        }
        if (incomeTarget < 0 || expenseLimit < 0) {
            throw new BadRequestException("Invalid values");
        }
    }

    public Integer getMonth() { return month; }
    public Integer getYear() { return year; }
    public Double getExpenseLimit() { return expenseLimit; }
    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }
}
