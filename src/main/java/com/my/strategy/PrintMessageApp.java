package com.my.strategy;

import com.my.strategy.MessageOut;
import com.my.strategy.OutStrategy;

public class PrintMessageApp {

    public static void main(String[] args) {
        String text = "Какой-то текст";
        String name = "Какое-то имя";
        String message1;
        MessageOut messageOut = new MessageOut();
        message1 = messageOut.outMessage(text, name);
        System.out.println(message1);

    }
}