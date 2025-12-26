package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.BudgetPlan;
import com.example.demo.model.BudgetSummary;
import com.example.demo.model.Category;
import com.example.demo.model.TransactionLog;
import com.example.demo.repository.BudgetSummaryRepository;
import com.example.demo.repository.TransactionRepository;
import com.example.demo.service.BudgetSummaryService;

@Service
public class BudgetSummaryServiceImpl implements BudgetSummaryService {

    private final TransactionRepository transactionRepository;
    private final BudgetSummaryRepository summaryRepository;

    public BudgetSummaryServiceImpl(TransactionRepository transactionRepository,
                                    BudgetSummaryRepository summaryRepository) {
        this.transactionRepository = transactionRepository;
        this.summaryRepository = summaryRepository;
    }

    @Override
    public BudgetSummary generateSummary(BudgetPlan plan) {

        List<TransactionLog> logs =
                transactionRepository.findByUser(plan.getUser());

        double totalIncome = 0;
        double totalExpense = 0;

        for (TransactionLog log : logs) {

            if (Category.TYPE_INCOME.equals(log.getCategory().getType())) {
                totalIncome += log.getAmount();
            }

            if (Category.TYPE_EXPENSE.equals(log.getCategory().getType())) {
                totalExpense += log.getAmount();
            }
        }

        BudgetSummary summary = new BudgetSummary();
        summary.setBudgetPlan(plan);
        summary.setTotalIncome(totalIncome);
        summary.setTotalExpense(totalExpense);

        if (totalExpense <= plan.getExpenseLimit()) {
            summary.setStatus(BudgetSummary.STATUS_UNDER_LIMIT);
        } else {
            summary.setStatus(BudgetSummary.STATUS_OVER_LIMIT);
        }

        return summaryRepository.save(summary);
    }
}
