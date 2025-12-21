package com.example.demo.service;

import java.util.List;
import com.example.demo.model.BudgetSummary;

public interface BudgetSummaryService {
    BudgetSummary save(BudgetSummary summary);
    List<BudgetSummary> findAll();
}
