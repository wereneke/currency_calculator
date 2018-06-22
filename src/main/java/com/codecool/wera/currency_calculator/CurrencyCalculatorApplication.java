package com.codecool.wera.currency_calculator;

import com.codecool.wera.currency_calculator.controller.CurrencyController;
import com.codecool.wera.currency_calculator.currency.Currency;
import com.codecool.wera.currency_calculator.currency.CurrencyContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Map;

@SpringBootApplication
public class CurrencyCalculatorApplication{

	@Autowired
	CurrencyController controller;


	public static void main(String[] args) {
		SpringApplication.run(CurrencyCalculatorApplication.class, args);
	}

}
