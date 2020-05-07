package com.lacentrale.fraudmanagement.services;

import java.util.concurrent.TimeUnit;

public class QuotationService {

    public static final int QUOTATION = 35000;

    public double calculateQuotation() {
        try {
            TimeUnit.MILLISECONDS.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return QUOTATION;
    }
}
