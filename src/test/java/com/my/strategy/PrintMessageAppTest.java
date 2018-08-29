package com.my.strategy;

import com.my.model.InverseMessage;
import com.my.strategy.MessageOut;
import org.junit.Test;

import static org.junit.Assert.*;

public class PrintMessageAppTest {
    @Test
    public void messageOut () {
        String text = "Какой-то текст";
        String name = "Какое-то имя";
        String message1;
        MessageOut messageOut = new MessageOut();
        String result = messageOut.outMessage(text, name);
        assertEquals("Какой-то текстКакое-то имя", result);

    }
    @Test
    public void inverseMessageOut () {
        String text = "Какой-то текст";
        String name = "Какое-то имя";
        String message2;
        InverseMessageOut inverseMessageOut = new InverseMessageOut();
        String result = inverseMessageOut.outMessage(text, name);
        assertEquals("Какое-то имяКакой-то текст", result);
    }

}

