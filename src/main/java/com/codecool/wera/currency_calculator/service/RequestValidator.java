package com.codecool.wera.currency_calculator.service;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class RequestValidator {

    private Map<String, String> codes;

    public RequestValidator(Map<String, String> codes) {
        this.codes = codes;
    }

    public boolean isValid(HttpServletRequest request) {

        String clientSelling = request.getParameter("sell");
        String clientBuying = request.getParameter("buy");
        String sellingAmount = request.getParameter("amount");

        System.out.println(clientSelling + clientBuying + sellingAmount);

        if (codes.containsKey(clientSelling) &&
                codes.containsKey(clientBuying) &&
                sellingAmount.matches("\\d+(\\.\\d+)?")) return true;

        return false;
    }
}
