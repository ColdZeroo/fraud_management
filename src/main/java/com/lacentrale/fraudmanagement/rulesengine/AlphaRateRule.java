package com.lacentrale.fraudmanagement.rulesengine;

import com.lacentrale.fraudmanagement.model.Advertisement;
import com.lacentrale.fraudmanagement.model.Contacts;

import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AlphaRateRule extends DefaultRule {

    public AlphaRateRule(String name) {
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
            if(matcher.matches()) {
                String firstPart = matcher.group(1);
                String alphaNumericalString = firstPart.replaceAll("[^A-Za-z0-9]", "");
                return (double) alphaNumericalString.length() / firstPart.length() > 0.7;
            }
            return false;
        };
    }
}
