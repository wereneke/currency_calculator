package com.codecool.wera.currency_calculator.currency;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrencyContainer implements Serializable {

    private String table;
    private String no;
    private LocalDate tradingDate;
    private LocalDate effectiveDate;
    private Currency[] rates;
    private Map<String, Currency> codeMap;

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public LocalDate getTradingDate() {
        return tradingDate;
    }

    public void setTradingDate(LocalDate tradingDate) {
        this.tradingDate = tradingDate;
    }

    public LocalDate getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(LocalDate effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public Currency[] getRates() {
        return rates;
    }

    public void setRates(Currency[] rates) {
        this.rates = rates;
    }

    public Map<String, Currency> getCodeMap() {
        setCodeMap();
        return codeMap;
    }

    public void setCodeMap() {

        this.codeMap = Arrays.asList(rates).stream()
                .collect(Collectors.toMap(Currency::getCode, Function.identity()));
    }
}
