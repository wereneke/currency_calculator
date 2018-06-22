package com.codecool.wera.currency_calculator.service;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class CurrencyCalculator {

    public BigDecimal calculate(Float sellingAmount, Float sellPrice, Float buyPrice) {

        BigDecimal amount = BigDecimal.valueOf(sellingAmount);
        BigDecimal sPrice = BigDecimal.valueOf(sellPrice);
        BigDecimal bPrice = BigDecimal.valueOf(buyPrice);

        
        return null;
    }
}
