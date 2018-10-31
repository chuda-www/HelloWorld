package com.my.myspring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@ContextConfiguration("/beans.xml")

public class MainAppTest {

    @Autowired
    private HelloSpring obj;

    @Test
    public void test() {

        assertEquals("Hello!!!", obj.getMessage());

    }
}