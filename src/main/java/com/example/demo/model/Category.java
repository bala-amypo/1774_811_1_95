package com.example.demo.model;

import com.example.demo.exception.BadRequestException;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Category {

    public static final String INCOME = "INCOME";
    public static final String EXPENSE = "EXPENSE";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    private String type;

    public Category() {}

    public Category(Long id, String name, String type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public void validateType() {
        if (!INCOME.equals(type) && !EXPENSE.equals(type)) {
            throw new BadRequestException("Invalid category type");
        }
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getType() { return type; }

    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setType(String type) { this.type = type; }
}
