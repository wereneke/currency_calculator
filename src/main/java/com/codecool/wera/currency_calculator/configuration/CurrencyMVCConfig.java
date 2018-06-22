package com.codecool.wera.currency_calculator.configuration;

import com.codecool.wera.currency_calculator.logging.CurrencyRequestInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class CurrencyMVCConfig implements WebMvcConfigurer {

    @Autowired
    private CurrencyRequestInterceptor interceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(interceptor)
                .addPathPatterns("/currencies/*");
    }
}
