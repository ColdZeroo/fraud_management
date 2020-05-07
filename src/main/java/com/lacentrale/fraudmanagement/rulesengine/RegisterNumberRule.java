package com.lacentrale.fraudmanagement.rulesengine;

import com.lacentrale.fraudmanagement.model.Advertisement;
import com.lacentrale.fraudmanagement.model.Vehicle;
import com.lacentrale.fraudmanagement.services.BlacklistService;

import java.util.function.Predicate;

public class RegisterNumberRule extends DefaultRule {

    private final BlacklistService blacklistService;

    public RegisterNumberRule(String name, BlacklistService blacklistService) {
        super(name);
        this.blacklistService = blacklistService;
    }

    @Override
    public Predicate<Advertisement> evaluate() {
        return advertisement -> blacklistService
                .verifyRegistration(advertisement.getVehicle().map(Vehicle::getRegisterNumber).orElse(null));
    }
}
