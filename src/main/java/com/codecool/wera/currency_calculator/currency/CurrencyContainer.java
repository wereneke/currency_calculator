package com.codecool.wera.currency_calculator.currency;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class CurrencyContainer {

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
