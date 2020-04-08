package com.maxn.mockito.services;

import com.maxn.mockito.models.ReportModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ReportService {

    @Autowired
    private BudgetService budgetService;
    @Autowired
    private ReportEmailSender reportEmailSender;

    public ReportModel create(BigDecimal actual) {
        BigDecimal budget = budgetService.getBudget();
        BigDecimal forecast = calcForecast(budget, actual);

        ReportModel reportModel = new ReportModel(budget, actual, forecast);

        reportEmailSender.sendReport(reportModel);

        return reportModel;
    }

    private BigDecimal calcForecast(BigDecimal budget, BigDecimal actual) {
        budget = budget == null ? BigDecimal.ZERO : budget;
        actual = actual == null ? BigDecimal.ZERO : actual;

        return budget.subtract(actual);
    }

}
