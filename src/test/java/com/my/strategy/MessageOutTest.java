package com.my.strategy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MessageOutTest {
    @Test
    public void messageOut () {
        String text = "Какой-то текст";
        String name = "Какое-то имя";
        MessageOut messageOut = new MessageOut();
        String result = messageOut.outMessage(text, name);
        assertEquals("Какой-то текстКакое-то имя", result);

    }
}
