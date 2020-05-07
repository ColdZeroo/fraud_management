package com.lacentrale.fraudmanagement.rulesengine;

import com.lacentrale.fraudmanagement.model.Advertisement;
import com.lacentrale.fraudmanagement.model.Contacts;

import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberRateRule extends DefaultRule {

    public NumberRateRule(String name) {
        super(name);
    }

    @Override
    public Predicate<Advertisement> evaluate() {
        return advertisement -> {
            String regex = "^(.+)@(.+)$";
            Pattern pattern = Pattern.compile(regex);
            String email = advertisement.getContacts().map(Contacts::getEmail).orElse(null);
            if (email == null)
                return false;
            Matcher matcher = pattern.matcher(email);
            if (matcher.matches()) {
                String firstPart = matcher.group(1);
                String numericalString = firstPart.replaceAll("[^0-9]", "");
                return (double) numericalString.length() / firstPart.length() < 0.3;
            }
            return false;
        };
    }
}
