package com.my.exercises.mysorting;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserSortingComparable {

    public static void main(String[] args) {

//        User[] users = getUsers();
//        User[] sort = bubbleSort(users);
//        User[] sort = mergeSort(users);
//        User[] sort = insertionSort(users);
//
//        for (User user : sort) {
//        System.out.println(user.getName() + " " + user.getAge());
//        }
        User user1 = new User("Tom",22);
        User user2 = new User("Alice",30);
        User user3 = new User("Kate",26);
        User user4 = new User("Sam",31);
        User user5 = new User("Bob",26);
        List<User> list = new ArrayList <User>();
        list.add(user1);
        list.add(user2);
        list.add(user3);
        list.add(user4);
        list.add(user5);
        Collections.sort(list);
        for (User h: list) {
            System.out.println(h);
        }
//        Collections.sort(list); // call @compareTo(o1)
//        Collections.sort(list, User.nameComparator); // call @compare (o1,o2)
//        Collections.sort(list, User.idComparator); // call @compare (o1,o2)

    }
//    public int compareTo(User p){
//        return name.length()-p.getName().length();
//    }














//    ArrayList<String> people = new ArrayList<String>();
//    // добавим в список ряд элементов
//        people.add("Tom");
//        people.add("Alice");
//        people.add("Kate");
//        people.add("Sam");
//        people.add(1, "Bob"); // добавляем элемент по индексу 1
//
//        System.out.println(people.get(1));// получаем 2-й объект
//        people.set(1, "Robert"); // установка нового значения для 2-го объекта
//
//        System.out.printf("ArrayList has %d elements \n", people.size());
//        for(String person : people){
//
//        System.out.println(person);
//    }
//    // проверяем наличие элемента
//        if(people.contains("Tom")){
//
//        System.out.println("ArrayList contains Tom");
//    }
//
//    // удалим несколько объектов
//    // удаление конкретного элемента
//        people.remove("Robert");
//    // удаление по индексу
//        people.remove(0);
//
//    Object[] peopleArray = people.toArray();
//        for(Object person : peopleArray){
//
//        System.out.println(person);
//    }
//}
}
