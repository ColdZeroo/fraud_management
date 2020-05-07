package com.lacentrale.fraudmanagement.rulesengine;

import com.lacentrale.fraudmanagement.model.Advertisement;
import com.lacentrale.fraudmanagement.model.Contacts;

import java.util.function.Predicate;

public class FirstNameRule extends DefaultRule {

    public FirstNameRule(String name) {
        super(name);
    }

    @Override
    public Predicate<Advertisement> evaluate() {
        return advertisement -> advertisement.getContacts().map(Contacts::getFirstName).map(x -> x.length() > 2).orElse(false);
    }
}
