package com.my.myspring;

import org.springframework.beans.factory.annotation.Value;

public class MyService {
    @Value("${application.name}")
    private String nameX;

    public String getNameX() {
        return nameX;
    }

}
