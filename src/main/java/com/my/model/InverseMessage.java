package com.my.model;

public class InverseMessage extends GeneralMessage {

    public String getNameText() {
        return getName()+getText();
    }
}

