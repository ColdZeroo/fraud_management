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
public class FirstNameRuleTest {

    @Mock
    private Advertisement advertisement;

    FirstNameRule firstNameRule = new FirstNameRule("First Name Rule Test");

    @Test
    public void should_return_true_when_first_name_length_is_greater_than_2() {
        Contacts contacts = new Contacts("Abraham", "Isac", "az@yopmail.com", null);
        when(advertisement.getContacts()).thenReturn(java.util.Optional.of(contacts));
        assertTrue(firstNameRule.evaluate().test(advertisement));
    }

    @Test
    public void should_return_false_when_first_name_length_is_lower_than_2() {
        Contacts contacts = new Contacts("Ab", "Isac", "az@yopmail.com", null);
        when(advertisement.getContacts()).thenReturn(java.util.Optional.of(contacts));
        assertFalse(firstNameRule.evaluate().test(advertisement));
    }
}