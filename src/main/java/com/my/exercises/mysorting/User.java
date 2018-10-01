package com.my.exercises.mysorting;

public class User implements Comparable<User>{
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public User(String name, int age){
        this.name = name;
        this.age = age;
            }
    @Override
    public int compareTo(User anotherUser){

//        if (this.age < anotherUser.age) return -1;
//        if (this.age > anotherUser.age) return 1;
//        return 0;

          if (this.age == anotherUser.age) {
            return 0;
        } else if (this.age < anotherUser.age) {
            return -1;
        } else {
            return 1;
        }
    }

    @Override
    public String toString() {
        return name + " "+ age;
    }
}
////        String[] name = {"Viktoryia","Denis","Viktor","Dmitry","Olga"};
////        int[] age = {35,36,25,32,37};