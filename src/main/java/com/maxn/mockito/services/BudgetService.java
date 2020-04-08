package com.maxn.mockito.services;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class BudgetService {

    public BigDecimal getBudget() {
        // here is a request to database
        return BigDecimal.valueOf(100);
    }

}
