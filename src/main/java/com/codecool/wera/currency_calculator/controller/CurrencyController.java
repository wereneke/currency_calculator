package com.codecool.wera.currency_calculator.controller;

import com.codecool.wera.currency_calculator.currency.CurrencyContainer;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

@Controller
public class CurrencyController {

    private RestTemplate restTemplate = new RestTemplate();

    private CurrencyContainer[] currencyContainerArray;
    private CurrencyContainer currencyContainer;

    public void getTicks() {

        String url = "http://api.nbp.pl/api/exchangerates/tables/C/";
        currencyContainerArray = restTemplate.getForObject(url, CurrencyContainer[].class);
        currencyContainer = currencyContainerArray[0];
    }

    public CurrencyContainer getCurrencyContainer() {
        return currencyContainer;
    }
}
