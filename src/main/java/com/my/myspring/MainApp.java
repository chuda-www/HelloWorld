package com.my.myspring;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        final Logger log = LogManager.getLogger(MainApp.class.getName());

        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        HelloSpring obj = (HelloSpring) context.getBean("helloWorld");
        System.out.println("Your message: " + obj.getMessage());
        log.debug("Your message: " + obj.getMessage());
    }
}

