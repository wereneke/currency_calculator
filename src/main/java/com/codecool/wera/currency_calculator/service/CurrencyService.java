package com.codecool.wera.currency_calculator.service;

import com.codecool.wera.currency_calculator.currency.Currency;
import com.codecool.wera.currency_calculator.currency.CurrencyContainer;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CurrencyService {

    private RestTemplate restTemplate;
    private CurrencyContainer currencyContainer;
    private RequestValidator validator;

    public CurrencyService(CurrencyContainer currencyContainer) {

        this.restTemplate = new RestTemplate();
        this.currencyContainer = getCurrencyContainer();
        this.validator = new RequestValidator(getAvailableCurrencies());
    }

    private CurrencyContainer getCurrencyContainer() {

        String url = "http://api.nbp.pl/api/exchangerates/tables/C/";
        CurrencyContainer[] currencyContainerArray = restTemplate.getForObject(url, CurrencyContainer[].class);
        return currencyContainerArray[0];
    }

    public Map<String, String> getAvailableCurrencies() {
        return this.currencyContainer.getCodeMap().entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue().getCurrency()));
    }

    public String calculate(HttpServletRequest request) {
        return null;
    }

    public Currency[] getExchangeRates() {
        return null;
    }

    public boolean isRequestValid(HttpServletRequest request) {
        return validator.isValid(request);
    }
}
