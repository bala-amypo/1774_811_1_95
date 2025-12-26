package com.example.demo.model;

public class Category {

    public static final String TYPE_INCOME = "INCOME";
    public static final String TYPE_EXPENSE = "EXPENSE";

    // SERVICE EXPECTS THESE
    public static final String INCOME = "INCOME";
    public static final String EXPENSE = "EXPENSE";

    private Long id;
    private String name;
    private String type;

    public Category() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    // REQUIRED BY SERVICE
    public void validateType() {
        if (!INCOME.equals(type) && !EXPENSE.equals(type)) {
            throw new IllegalArgumentException("Invalid category type");
        }
    }
}
