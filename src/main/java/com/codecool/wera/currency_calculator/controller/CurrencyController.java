package com.codecool.wera.currency_calculator.controller;

import com.codecool.wera.currency_calculator.currency.Currency;
import com.codecool.wera.currency_calculator.currency.CurrencyContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

@Controller
public class CurrencyController {

    private RestTemplate restTemplate = new RestTemplate();

    @Autowired
    private CurrencyContainer currencyContainer;

    private Currency[] currencies;

    private void getTicks() {
        String url = "http://api.nbp.pl/api/exchangerates/tables/C/";
        this.currencies = restTemplate.getForObject(url, Currency[].class);
    }


}
