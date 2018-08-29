package com.my.strategy;

import com.my.model.InverseMessage;
import com.my.strategy.MessageOut;
import com.my.strategy.OutStrategy;

public class PrintMessageApp {

    public static void main(String[] args) {
        String text = "Какой-то текст";
        String name = "Какое-то имя";
        String message1;
        String message2;
        MessageOut messageOut = new MessageOut();
        message1 = messageOut.outMessage(text, name);
        InverseMessageOut inverseMessageOut = new InverseMessageOut();
        message2=inverseMessageOut.outMessage(text,name);
        System.out.println(message1);
        System.out.println(message2);


    }
}