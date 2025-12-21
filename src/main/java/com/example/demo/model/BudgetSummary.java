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

    // getters & setters
}
