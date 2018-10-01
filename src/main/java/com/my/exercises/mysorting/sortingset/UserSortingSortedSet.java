package com.my.exercises.mysorting.sortingset;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

public class UserSortingSortedSet {
    public static void main(String[] args) {

        User user1 = new User("Tom", 21);
        User user2 = new User("Alice", 36);
        User user3 = new User("Kate", 26);
        User user4 = new User("Sam", 30);
        User user5 = new User("Bob", 27);

        SortedSet <User> users = new TreeSet <User>(Comparator.comparing(User::getName));
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);

        System.out.println(users);
        System.out.println("Размер treeSet = " + users.size());
        System.out.println("First element : " + users.first());
        System.out.println("Last element : " + users.last());
    }
}


