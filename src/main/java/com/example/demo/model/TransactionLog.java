package com.example.demo.model;

import com.example.demo.exception.BadRequestException;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "transaction_logs")
public class TransactionLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Category category;

    private Double amount;
    private String description;
    private LocalDate transactionDate;

    public TransactionLog() {}

    public TransactionLog(Long id, User user, Category category,
                          Double amount, String description, LocalDate transactionDate) {
        this.id = id;
        this.user = user;
        this.category = category;
        this.amount = amount;
        this.description = description;
        this.transactionDate = transactionDate;
    }

    public void validate() {
        if (amount == null || amount <= 0) {
            throw new BadRequestException("Amount must be > 0");
        }
        if (transactionDate.isAfter(LocalDate.now())) {
            throw new BadRequestException("Future date not allowed");
        }
    }

    public Double getAmount() { return amount; }
    public Category getCategory() { return category; }
    public void setUser(User user) { this.user = user; }
}
