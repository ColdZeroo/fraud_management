package com.lacentrale.fraudmanagement.rulesengine;

import com.lacentrale.fraudmanagement.model.Advertisement;
import com.lacentrale.fraudmanagement.services.QuotationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class QuotationRateRuleTest {

    @Mock
    private Advertisement advertisement;

    private final QuotationService quotationService = new QuotationService();
    private final QuotationRateRule quotationRateRule = new QuotationRateRule("Quotation Rate Rule Test", quotationService);

    @Test
    public void should_return_true_when_price_is_20percent_above_or_under_quotation() {
        when(advertisement.getPrice()).thenReturn(34_000d); // is 3% under 35_000d
        assertTrue(quotationRateRule.evaluate().test(advertisement));
    }

    @Test
    public void should_return_true_when_price_is_not_20percent_above_or_under_quotation() {
        when(advertisement.getPrice()).thenReturn(20_000d); // is 43% under 35_000d
        assertFalse(quotationRateRule.evaluate().test(advertisement));
    }

}
