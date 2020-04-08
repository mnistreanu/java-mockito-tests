package com.maxn.mockito;

import com.maxn.mockito.models.ReportModel;
import com.maxn.mockito.services.BudgetService;
import com.maxn.mockito.services.ReportEmailSender;
import com.maxn.mockito.services.ReportService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ReportTests {

    @InjectMocks
    private ReportService reportService;

    @Mock
    private BudgetService budgetService;

    @Mock
    private ReportEmailSender reportEmailSender;

    @Test
    public void testForecastCalculation() {
        BigDecimal budget = BigDecimal.valueOf(1000);
        BigDecimal actual = BigDecimal.TEN;
        BigDecimal forecast = BigDecimal.valueOf(990);
        ReportModel expectedReportModel = new ReportModel(budget, actual, forecast);

        when(budgetService.getBudget()).thenReturn(budget);

        ReportModel actualReportModel = reportService.create(actual);

        assertEquals(expectedReportModel, actualReportModel);
    }

    @Test
    public void testEmailSender() {
        reportService.create(BigDecimal.TEN);
        verify(reportEmailSender).sendReport(any());
    }

}
