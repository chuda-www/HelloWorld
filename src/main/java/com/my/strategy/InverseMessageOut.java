package com.my.strategy;

public class InverseMessageOut implements OutStrategy {

    @Override
    public String outMessage(String text, String name) {
        return name + text;
    }
}
