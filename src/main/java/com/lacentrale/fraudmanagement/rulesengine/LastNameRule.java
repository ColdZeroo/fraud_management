package com.lacentrale.fraudmanagement.rulesengine;

import com.lacentrale.fraudmanagement.model.Advertisement;
import com.lacentrale.fraudmanagement.model.Contacts;

import java.util.function.Predicate;

public class LastNameRule extends DefaultRule {

    public LastNameRule(String name) {
        super(name);
    }

    @Override
    public Predicate<Advertisement> evaluate() {
        return advertisement -> advertisement.getContacts().map(Contacts::getLastName).map(x -> x.length() > 2).orElse(false);
    }
}
