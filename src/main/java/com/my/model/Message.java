package com.my.model;

public class Message extends GeneralMessage {

   public String getTextName() {
        return getText() + getName();
    }

}

