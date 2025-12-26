package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.BudgetPlan;
import com.example.demo.model.BudgetSummary;
import com.example.demo.model.Category;
import com.example.demo.model.TransactionLog;
import com.example.demo.repository.BudgetSummaryRepository;
import com.example.demo.repository.TransactionLogRepository;
import com.example.demo.service.BudgetSummaryService;

@Service
public class BudgetSummaryServiceImpl implements BudgetSummaryService {

    private final BudgetSummaryRepository budgetSummaryRepository;
    private final TransactionLogRepository transactionLogRepository;

    public BudgetSummaryServiceImpl(BudgetSummaryRepository budgetSummaryRepository,
                                    TransactionLogRepository transactionLogRepository) {
        this.budgetSummaryRepository = budgetSummaryRepository;
        this.transactionLogRepository = transactionLogRepository;
    }

    @Override
    public BudgetSummary generateSummary(BudgetPlan plan) {

        List<TransactionLog> logs =
                transactionLogRepository.findByUser(plan.getUser());

        double income = 0;
        double expense = 0;

        for (TransactionLog log : logs) {
            if (Category.TYPE_INCOME.equals(log.getCategory().getType())) {
                income += log.getAmount();
            }
            if (Category.TYPE_EXPENSE.equals(log.getCategory().getType())) {
                expense += log.getAmount();
            }
        }

        BudgetSummary summary = new BudgetSummary();
        summary.setBudgetPlan(plan);
        summary.setTotalIncome(income);
        summary.setTotalExpense(expense);

        if (expense <= plan.getExpenseLimit()) {
            summary.setStatus(BudgetSummary.STATUS_UNDER_LIMIT);
        } else {
            summary.setStatus(BudgetSummary.STATUS_OVER_LIMIT);
        }

        return budgetSummaryRepository.save(summary);
    }
}
