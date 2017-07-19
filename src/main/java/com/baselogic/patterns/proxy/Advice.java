package com.baselogic.patterns.proxy;

public class Advice {

    public int preOperation(int input){
        return input *= 100;
    }

    public int postOperation(int input){
        return input *= 1000;
    }

    public String preOperation(String input) {
        return "audit: " + input;
    }

    public String postOperation(String input) {
        return "POST OPERATION: " + input;
    }

}
