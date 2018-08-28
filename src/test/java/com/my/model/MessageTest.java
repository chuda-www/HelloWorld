package com.my.model;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MessageTest {

    @Test
    public void getText() {
        Message message = new Message();
        message.setText("Hello!!!");
        String result = message.getText();
        assertEquals("Hello!!!", result);

    }

    @Test
    public void getTextName() {
        Message message = new Message();
        message.setName("Serg");
        message.setText("Hello!!!");
        String result = message.getTextName();
        assertEquals("Hello!!!Serg", result);
    }

}