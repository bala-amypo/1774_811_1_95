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

    // getters & setters
}
