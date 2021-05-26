package com.forex.domain;

import java.util.ArrayList;
import java.util.List;

public class Currency {
    private List<String> currencies;

    public Currency(){
        this.currencies = new ArrayList<String>();
        this.currencies.add("EURGBP");
        this.currencies.add("EURUSD");
        this.currencies.add("CADJPY");
    }

    public List<String> getCurrencies() {
        return this.currencies;
    }
}
