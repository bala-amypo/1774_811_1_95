package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.BudgetPlan;
import com.example.demo.model.BudgetSummary;

@Repository
public interface BudgetSummaryRepository extends JpaRepository<BudgetSummary, Long> {

    Optional<BudgetSummary> findByBudgetPlan(BudgetPlan budgetPlan);
}
