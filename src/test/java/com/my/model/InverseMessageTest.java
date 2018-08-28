package com.my.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InverseMessageTest {
    @Test
    public void getNameText() {
        InverseMessage message = new InverseMessage();
        message.setName("Someone's name ");
        message.setText("Hello!!!");
        String result = message.getNameText();

        assertEquals("Someone's name Hello!!!", result);
    }
}
