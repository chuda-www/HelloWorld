package com.my;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MessageTest {

    @Test
    void getText(){
        Message message=new Message();
        message.setText("Hello!!!");
        String result = message.getText();
        Assertions.assertEquals("Hello!!!", result);


    }
    @Test
    void getTextName() {
        Message message=new Message();
        message.setName("Serg");
        message.setText("Hello!!!");
        String result=message.getText()+message.getName();
        Assertions.assertEquals("Hello!!!Serg", result);
    }

}