package com.baselogic.patterns.structural.proxy;

public class Proxy implements Subject {

    // Agg:
    private Target target;
    private Advice advice;

    public Proxy(){
        target = new Target();
        advice = new Advice();
    }

    @Override
    public int operationReturningNumericValue(int input) {
        // Pre Operation:
        int result = advice.preOperation(input);

        // Target Operation
        int intResult = target.operationReturningNumericValue(result);

        // Post Operation
        return advice.postOperation(intResult);
    }

    @Override
    public String operationReturningStringValue(String input) {

        String result = advice.preOperation(input);

        String strResult = target.operationReturningStringValue(result);

        return advice.postOperation(strResult);
    }
}
