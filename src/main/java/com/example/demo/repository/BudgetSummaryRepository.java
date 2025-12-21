package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.BudgetSummary;
import com.example.demo.model.BudgetPlan;

public interface BudgetSummaryRepository extends JpaRepository<BudgetSummary, Long> {
    BudgetSummary findByBudgetPlan(BudgetPlan plan);
}
