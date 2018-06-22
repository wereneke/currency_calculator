package com.codecool.wera.currency_calculator.controller;

import com.codecool.wera.currency_calculator.currency.Currency;
import com.codecool.wera.currency_calculator.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("/currencies")
public class CurrencyController {

    @Autowired
    private CurrencyService service;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Map<String, String> getAvailableCurrencies() {
        return service.getAvailableCurrencies();
    }

    @RequestMapping(value = "/calculator", method = RequestMethod.POST)
    @ResponseBody
    public String calculate(HttpServletRequest request) {

        if (service.isRequestValid(request)) {
            return service.calculate(request);
        } else throw new BadRequestException();
    }

    @RequestMapping(value = "/exchange", method = RequestMethod.GET)
    @ResponseBody
    public Currency[] getExchangeRates() {
        return service.getExchangeRates();
    }

}
