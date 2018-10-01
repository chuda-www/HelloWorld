package com.my.exercises.mysorting.treemap;

import java.util.Map;
import java.util.TreeMap;

public class UserSortingTreeMap {

    public static void main(String[] args) {
        Map <Integer, String> users = new TreeMap <Integer, String>();

        users.put(21, "Tom");
        users.put(36, "Alice");
        users.put(26, "Kate");
        users.put(30, "Sam");
        users.put(27, "Bob");
        System.out.println("Ключи : " + users.keySet());


        for (Map.Entry <Integer, String> pair : users.entrySet()) {
            System.out.println("Key+Value" + pair.getKey() + "  " + pair.getValue());
        }
        System.out.println(users.hashCode());
    }
}

//                   if (users.getKey()<20){
//              System.out.println("Пользователя не существует");
//          }
//
//        if (pair.getKey()<20 && pair.getKey()<30){
//
//
//        System.out.println("Ключ = 3, значение = " + users.get(3));
//        for(int i = 0; i < users.size(); i++) {
//            if (users.getKey() > 20) || (users.getKey() < 30) {
//                System.out.println("Набор данных : " + users);
//            }
//            if (){}

