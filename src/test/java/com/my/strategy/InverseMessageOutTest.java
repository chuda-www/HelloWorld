package com.my.strategy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InverseMessageOutTest {
    @Test
    public void inverseMessageOut () {
        String text = "текст";
        String name = "имя";
        InverseMessageOut inverseMessageOut = new InverseMessageOut();
        String result = inverseMessageOut.outMessage(text, name);
        assertEquals("имятекст", result);
    }
}
