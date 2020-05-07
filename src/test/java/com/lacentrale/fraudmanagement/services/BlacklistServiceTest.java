package com.lacentrale.fraudmanagement.services;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BlacklistServiceTest {

    BlacklistService blacklistService = new BlacklistService();

    @Test
    public void should_verify_if_register_number_is_not_blacklisted() {
        assertTrue(blacklistService.verifyRegistration("AC234DF"));
    }

    @Test
    public void should_verify_if_register_number_is_blacklisted() {
        assertFalse(blacklistService.verifyRegistration("AA123AA"));
    }
}
