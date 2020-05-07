package com.lacentrale.fraudmanagement.services;

import java.util.concurrent.TimeUnit;

public class BlacklistService {

    public static final String BLACKLISTED_REGISTRATION = "AA123AA";

    public boolean verifyRegistration(String registerNumber) {
        try {
            TimeUnit.MILLISECONDS.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return ! BLACKLISTED_REGISTRATION.equals(registerNumber);
    }
}
