package com.lacentrale.fraudmanagement.rulesengine;

import com.lacentrale.fraudmanagement.model.Advertisement;

import java.util.function.Predicate;

public abstract class DefaultRule implements Rule<Advertisement> {

    protected String name;

    public DefaultRule(String name) {
        this.name = name;
    }

    public abstract Predicate<Advertisement> evaluate();

    public String getName() {
        return name;
    }
}
