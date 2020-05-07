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
public class AlphaRateRuleTest {

    @Mock
    private Advertisement advertisement;

    AlphaRateRule alphaRateRule = new AlphaRateRule("Alpha Rate Rule Test");

    @Test
    public void should_return_true_when_alphanumerical_percentage_is_above_70() {
        Contacts contacts = new Contacts("Abraham", "Isac", "az-132&@yopmail.com", null); // 71%
        when(advertisement.getContacts()).thenReturn(java.util.Optional.of(contacts));
        assertTrue(alphaRateRule.evaluate().test(advertisement));
    }

    @Test
    public void should_return_false_when_alphanumerical_percentage_is_under_70() {
        Contacts contacts = new Contacts("Abraham", "Isac", "az-13&@yopmail.com", null); // 67%
        when(advertisement.getContacts()).thenReturn(java.util.Optional.of(contacts));
        assertFalse(alphaRateRule.evaluate().test(advertisement));
    }
}
