package com.codecool.wera.currency_calculator.service;

import com.codecool.wera.currency_calculator.currency.Currency;
import com.codecool.wera.currency_calculator.currency.CurrencyContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CurrencyService {

    private RestTemplate restTemplate;
    private CurrencyContainer currencyContainer;

    @Autowired
    private CurrencyCalculator calculator;

    public CurrencyService(CurrencyContainer currencyContainer) {

        this.restTemplate = new RestTemplate();
        getAvailableCurrencies();
    }

    private void getCurrencyContainer() {

        String url = "http://api.nbp.pl/api/exchangerates/tables/C/";
        CurrencyContainer[] currencyContainerArray = restTemplate.getForObject(url, CurrencyContainer[].class);
        this.currencyContainer = currencyContainerArray[0];
    }

    public Map<String, String> getAvailableCurrencies() {

        getCurrencyContainer();
        return this.currencyContainer.getCodeMap().entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue().getCurrency()));
    }

    public String calculate(HttpServletRequest request) {

        getCurrencyContainer();
        Map<String, Currency> codeMap = currencyContainer.getCodeMap();

        String clientSelling = request.getParameter("sell");
        String clientBuying = request.getParameter("buy");
        String sellingAmount = request.getParameter("amount");

        Float sellPrice = codeMap.get(clientSelling).getAsk();
        Float buyPrice = codeMap.get(clientBuying).getBid();
        Float amount = Float.valueOf(sellingAmount);

        return calculator.calculate(amount, sellPrice, buyPrice).toString();
    }

    public Currency[] getExchangeRates() {

        getCurrencyContainer();
        return this.currencyContainer.getRates();
    }

    public boolean isRequestValid(HttpServletRequest request) {
        return new RequestValidator(getAvailableCurrencies()).isValid(request);
    }
}
