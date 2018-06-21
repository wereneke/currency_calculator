package com.codecool.wera.currency_calculator.service;

import com.codecool.wera.currency_calculator.currency.Currency;
import com.codecool.wera.currency_calculator.currency.CurrencyContainer;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Service
public class CurrencyService {

    private RestTemplate restTemplate = new RestTemplate();
    private CurrencyContainer currencyContainer;

    private void getTicks() {

        String url = "http://api.nbp.pl/api/exchangerates/tables/C/";
        CurrencyContainer[] currencyContainerArray = restTemplate.getForObject(url, CurrencyContainer[].class);
        currencyContainer = currencyContainerArray[0];
    }

    public Map<String, String> getAvailableCurrencies() {
        return new HashMap<>();
    }

    public String calculate(HttpServletRequest request) {
        return null;
    }

    public Currency[] getExchangeRates() {
        return null;
    }
}
