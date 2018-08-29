package com.my.Strategy;

import com.my.strategy.MessageOut;
import org.junit.Test;

import static org.junit.Assert.*;

public class PrintMessageAppTest {
    @Test
    public void main() {
        String text = "Какой-то текст";
        String name = "Какое-то имя";
        String message1;
        MessageOut messageOut = new MessageOut();
        String result = messageOut.outMessage(text, name);
        assertEquals("Какой-то текстКакое-то имя", result);

    }
}

