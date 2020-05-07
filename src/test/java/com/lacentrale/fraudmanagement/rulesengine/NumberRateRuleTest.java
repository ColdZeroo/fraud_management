package com.lacentrale.fraudmanagement.rulesengine;

import com.lacentrale.fraudmanagement.model.Advertisement;
import com.lacentrale.fraudmanagement.model.Contacts;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class NumberRateRuleTest {

    @Mock
    private Advertisement advertisement;

    NumberRateRule numberRateRule = new NumberRateRule("Number Rate Rule Test");

    @Test
    public void should_return_true_when_numerical_percentage_is_under_30() {
        Contacts contacts = new Contacts("Abraham", "Isac", "az-2&@yopmail.com", null); // 20%
        when(advertisement.getContacts()).thenReturn(java.util.Optional.of(contacts));
        assertTrue(numberRateRule.evaluate().test(advertisement));
    }

    @Test
    public void should_return_false_when_numerical_percentage_is_above_30() {
        Contacts contacts = new Contacts("Abraham", "Isac", "az-13&@yopmail.com", null); // 33%
        when(advertisement.getContacts()).thenReturn(java.util.Optional.of(contacts));
        assertFalse(numberRateRule.evaluate().test(advertisement));
    }
}
