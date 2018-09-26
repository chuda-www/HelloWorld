package com.my.exercises;
import java.text.NumberFormat ;
import java.time.format.DateTimeFormatter ;

public class Formats {
    public static void main ( String [] args ){
        //для вывода числа с разделителями групп:
        NumberFormat nf = NumberFormat.getNumberInstance() ;
        System.out.println( "\nЧисло: " + nf.format(123456789) ) ;
        //для вывода числа с символом валюты:
        NumberFormat cf = NumberFormat.getCurrencyInstance() ;
        System.out.println( "\nВалюта: " + cf.format(1234.50f) ) ;
        //для вывода числа со знаком процента
        NumberFormat pf = NumberFormat.getPercentInstance();
        System.out.println( "\nПроцент: " + pf.format( 0.75f ) ) ;
        //оператор, создающий объект LocalDateTime, содержащий
        //значение текущего времени.
        java.time.LocalDateTime now =
                java.time.LocalDateTime.now() ;
        //операторы для вывода форматированного значения даты:
        DateTimeFormatter df =
                DateTimeFormatter.ofPattern( "MMM d, yyy" ) ;
        System.out.println( "\nДата: " + now.format( df ) ) ;
        //операторы для вывода форматированного значения времени.
        DateTimeFormatter tf =
        DateTimeFormatter.ofPattern( "h:m a" ) ;
        System.out.println( "\nВремя: " + now.format( tf ) ) ;

    }

}
