package com.my.model;

public class MyFirstApp {

      public static void main(String[] args){

        Message message = new Message();
        message.setText("Hello!!!");
        System.out.println("Your message:"+ message.getText());
    }
}
