package com.example.demo.service;

import com.example.demo.model.BudgetPlan;
import com.example.demo.model.BudgetSummary;

public interface BudgetSummaryService {

    BudgetSummary generateSummary(BudgetPlan plan);
}
