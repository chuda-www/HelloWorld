package com.my.model;

public class InverseMessage {
    private String text;
    private String name;

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getNameText() {
        return name + text;
    }
}

