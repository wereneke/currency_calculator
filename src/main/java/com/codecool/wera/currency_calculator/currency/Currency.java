package com.codecool.wera.currency_calculator.currency;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
public class Currency {

    private String currency;
    private String code;
    private BigDecimal bid;
    private BigDecimal ask;

    public Currency(String currency, String code, BigDecimal bid, BigDecimal ask) {
        this.currency = currency;
        this.code = code;
        this.bid = bid;
        this.ask = ask;
    }

    public Currency() {}

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public BigDecimal getBid() {
        return bid;
    }

    public void setBid(BigDecimal bid) {
        this.bid = bid;
    }

    public BigDecimal getAsk() {
        return ask;
    }

    public void setAsk(BigDecimal ask) {
        this.ask = ask;
    }
}
