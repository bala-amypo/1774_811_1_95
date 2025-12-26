package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.BudgetSummaryService;

import java.time.LocalDate;
import java.util.List;

public class BudgetSummaryServiceImpl implements BudgetSummaryService {

    private final BudgetSummaryRepository summaryRepo;
    private final BudgetPlanRepository planRepo;
    private final TransactionLogRepository txRepo;

    public BudgetSummaryServiceImpl(BudgetSummaryRepository summaryRepo,
                                    BudgetPlanRepository planRepo,
                                    TransactionLogRepository txRepo) {
        this.summaryRepo = summaryRepo;
        this.planRepo = planRepo;
        this.txRepo = txRepo;
    }

    @Override
    public BudgetSummary generateSummary(Long budgetPlanId) {
        BudgetPlan plan = planRepo.findById(budgetPlanId).orElseThrow();

        LocalDate start = LocalDate.of(plan.getYear(), plan.getMonth(), 1);
        LocalDate end = start.withDayOfMonth(start.lengthOfMonth());

        List<TransactionLog> logs =
                txRepo.findByUserAndTransactionDateBetween(plan.getUser(), start, end);

        double income = logs.stream()
                .filter(l -> Category.INCOME.equals(l.getCategory().getType()))
                .mapToDouble(TransactionLog::getAmount).sum();

        double expense = logs.stream()
                .filter(l -> Category.EXPENSE.equals(l.getCategory().getType()))
                .mapToDouble(TransactionLog::getAmount).sum();

        String status = expense <= plan.getExpenseLimit()
                ? BudgetSummary.UNDER_LIMIT
                : BudgetSummary.OVER_LIMIT;

        BudgetSummary summary = new BudgetSummary();
        summary.setBudgetPlan(plan);
        summary.setTotalIncome(income);
        summary.setTotalExpense(expense);
        summary.setStatus(status);

        return summaryRepo.save(summary);
    }

    @Override
    public BudgetSummary getSummary(Long budgetPlanId) {
        BudgetPlan plan = planRepo.findById(budgetPlanId).orElseThrow();
        return summaryRepo.findByBudgetPlan(plan).orElseThrow();
    }
}
