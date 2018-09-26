package com.my.exercises;

import java.math.BigDecimal;
import java.util.Arrays;

public class MyJava {
    public static void main(String[] args) {
        Arrays.stream(args).forEach(a->System.out.println(">>>>" + a));
        float daysFloat = 365.25f ;
        String weeksString = "52" ;
        int daysInt = (int) daysFloat ;
        int weeksInt = Integer.parseInt( weeksString ) ;
        int week = ( daysInt / weeksInt ) ;
        System.out.println( "Дней в неделе: " + week ) ;

    }
}