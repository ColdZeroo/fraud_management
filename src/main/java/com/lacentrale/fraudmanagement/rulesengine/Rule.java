package com.lacentrale.fraudmanagement.rulesengine;

import org.springframework.stereotype.Component;

import java.util.function.Predicate;

@FunctionalInterface
public interface Rule<T> {
    String name = "DEFAULT";
    Predicate<T> evaluate();
    default String getName() {
        return name;
    }
}
