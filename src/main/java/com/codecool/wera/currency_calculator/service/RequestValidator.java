package com.codecool.wera.currency_calculator.service;

import com.codecool.wera.currency_calculator.currency.Currency;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Component
public class RequestValidator {

    public boolean isValid(HttpServletRequest request, Map<String, Currency> codes) {

        String clientSelling = request.getParameter("sell");
        String clientBuying = request.getParameter("buy");
        String sellingAmount = request.getParameter("amount");

        if (codes.containsKey(clientSelling) &&
                codes.containsKey(clientBuying) &&
                sellingAmount.matches("\\d+(\\.\\d+)?")) return true;

        return false;
    }
}
