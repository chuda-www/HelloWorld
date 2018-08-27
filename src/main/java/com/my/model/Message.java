package com.my.model;

public class Message {

    private String text;
    private String name;

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTextName() {
        return text + name;
    }
}

