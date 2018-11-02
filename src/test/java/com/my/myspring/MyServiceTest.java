package com.my.myspring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@ContextConfiguration("/beans.xml")
public class MyServiceTest {
    @Autowired
    private MyService service;

    @Test
    public void testMyService() {

        assertEquals("testName", service.getNameX());

    }
}