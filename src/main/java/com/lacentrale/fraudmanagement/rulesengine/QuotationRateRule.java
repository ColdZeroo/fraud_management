package com.lacentrale.fraudmanagement.rulesengine;

import com.lacentrale.fraudmanagement.model.Advertisement;
import com.lacentrale.fraudmanagement.services.QuotationService;
import java.util.function.Predicate;

public class QuotationRateRule extends DefaultRule {

    private final QuotationService quotationService;

    public QuotationRateRule(String name, QuotationService quotationService) {
        super(name);
        this.quotationService = quotationService;
    }

    @Override
    public Predicate<Advertisement> evaluate() {
        return advertisement -> {
            double quotation = quotationService.calculateQuotation();
            return quotation * 0.8 < advertisement.getPrice()
                    && advertisement.getPrice() < quotation * 1.2;
        };
    }
}
