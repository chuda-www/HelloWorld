package com.my;

public class MyFirstApp {

    public static void main(String[] args){

        Message message = new Message();
        message.setT("Hello!!!");
        System.out.println("Your message:"+ message.getT());
    }
}
