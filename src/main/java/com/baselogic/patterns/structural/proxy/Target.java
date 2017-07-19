package com.baselogic.patterns.structural.proxy;

// CANNOT CHANGE ANYTHING
public final class Target implements Subject {

    @Override
    public int operationReturningNumericValue(int input){
        // Assume that we cannot change anything in this class
        // 500 legacy lines of code.
        return input += 42;
    }

    @Override
    public String operationReturningStringValue(String input) {
        return "prefix: " + input; // "audit: input"
    }

}
