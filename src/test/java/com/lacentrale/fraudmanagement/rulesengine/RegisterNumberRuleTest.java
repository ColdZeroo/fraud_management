package com.lacentrale.fraudmanagement.rulesengine;

import com.lacentrale.fraudmanagement.model.Advertisement;
import com.lacentrale.fraudmanagement.model.Vehicle;
import com.lacentrale.fraudmanagement.services.BlacklistService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class RegisterNumberRuleTest {

    @Mock
    private Advertisement advertisement;

    private final BlacklistService blacklistService = new BlacklistService();
    private final RegisterNumberRule registerNumberRule = new RegisterNumberRule("Register Number Rule Test", blacklistService);

    @Test
    public void should_return_true_when_register_number_is_not_blacklisted() {
        Vehicle vehicle = new Vehicle("V40", "AC234DF", "D2", "Volvo", "2015","110000");
        when(advertisement.getVehicle()).thenReturn(java.util.Optional.of(vehicle));
        assertTrue(registerNumberRule.evaluate().test(advertisement));
    }

    @Test
    public void should_return_false_when_register_number_is_blacklisted() {
        Vehicle vehicle = new Vehicle("V40", "AA123AA", "D2", "Volvo", "2015","110000");
        when(advertisement.getVehicle()).thenReturn(java.util.Optional.of(vehicle));
        assertFalse(registerNumberRule.evaluate().test(advertisement));
    }
}
