package com.codecool.wera.currency_calculator.service;

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class RequestValidator {

    public boolean isValid(HttpServletRequest request) {
        return true;
    }
}
