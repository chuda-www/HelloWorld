package com.my.strategy;

public class MessageOut implements OutStrategy {
    @Override
    public String outMessage(String text, String name) {
        return text + name;
    }
}
