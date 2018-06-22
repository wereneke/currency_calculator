package com.codecool.wera.currency_calculator.service;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class RequestValidator {

    private Map<String, String> codes;

    public RequestValidator(Map<String, String> codes) {
        this.codes = codes;
    }

    public boolean isValid(HttpServletRequest request) {

        return true;
    }
}
