package com.maxn.mockito.models;

import java.math.BigDecimal;
import java.util.Objects;

public class ReportModel {

    private BigDecimal budget, actual, forecast;

    public ReportModel(BigDecimal budget, BigDecimal actual, BigDecimal forecast) {
        this.budget = budget;
        this.actual = actual;
        this.forecast = forecast;
    }

    public BigDecimal getBudget() {
        return budget;
    }

    public void setBudget(BigDecimal budget) {
        this.budget = budget;
    }

    public BigDecimal getActual() {
        return actual;
    }

    public void setActual(BigDecimal actual) {
        this.actual = actual;
    }

    public BigDecimal getForecast() {
        return forecast;
    }

    public void setForecast(BigDecimal forecast) {
        this.forecast = forecast;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReportModel that = (ReportModel) o;
        return Objects.equals(budget, that.budget) &&
                Objects.equals(actual, that.actual) &&
                Objects.equals(forecast, that.forecast);
    }

    @Override
    public int hashCode() {
        return Objects.hash(budget, actual, forecast);
    }
}
