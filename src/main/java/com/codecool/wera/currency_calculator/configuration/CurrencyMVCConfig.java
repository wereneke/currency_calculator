package com.codecool.wera.currency_calculator.configuration;



import com.codecool.wera.currency_calculator.CurrencyRequestInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CurrencyMVCConfig implements WebMvcConfigurer {

    @Autowired
    private CurrencyRequestInterceptor currencyRequestInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(currencyRequestInterceptor).addPathPatterns("/**/currencies/**/");
    }
}
