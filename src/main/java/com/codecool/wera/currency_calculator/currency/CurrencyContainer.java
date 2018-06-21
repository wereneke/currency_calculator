package com.codecool.wera.currency_calculator.currency;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;


@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrencyContainer implements Serializable {

    private String table;
    private String no;
    private LocalDate tradingDate;
    private LocalDate effectiveDate;
    private Currency[] rates;

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

    public void setCurrencies(Map<String, Currency> currencies) {
        this.currencies = currencies;
    }

    //maps its code to Currency
    private Map<String,Currency> currencies = new HashMap<>();

    public Map<String, Currency> getCurrencies() {
        return currencies;
    }

    public Currency getCurrencyByCode(String code) {

        if (!currencies.containsKey(code)) throw new IllegalArgumentException("no such code");
        return currencies.get(code);
    }

    public Map<String, String> getCodes() {

        Map<String, String> codeNames = currencies.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue().getCurrency()));

        return codeNames;
    }

}
