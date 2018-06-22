package com.codecool.wera.currency_calculator.currency;

import java.io.Serializable;

public class Currency implements Serializable {

    private String currency;
    private String code;
    private Float bid;
    private Float ask;

    public Currency(String currency, String code, Float bid, Float ask) {
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

    public Float getBid() {
        return bid;
    }

    public void setBid(Float bid) {
        this.bid = bid;
    }

    public Float getAsk() {
        return ask;
    }

    public void setAsk(Float ask) {
        this.ask = ask;
    }
}
