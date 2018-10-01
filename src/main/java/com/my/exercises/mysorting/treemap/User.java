package com.my.exercises.mysorting.treemap;

import java.util.Objects;
import java.util.TreeMap;

public class User implements Comparable <User> {
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

    public User(int age, String name) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return name + " " + age;
    }

    public int compareTo(User anotherUser) {
        if (this.age == anotherUser.age) {
            return 0;
        } else if (this.age < anotherUser.age) {
            return -1;
        } else {
            return 1;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getAge() == user.getAge() &&
                Objects.equals(getName(), user.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAge());
    }

//    @Override
//    public int hashCode(){
//        return Objects.hash(age);
//    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        User person = (User) o;
//        return age == person.age;
//    }


//    public int compareTo(User user) {
//        return this.getAge() - user.getAge();
//    }
//    @Override
//    public Comparator <User> comparator(int age) {
//        return null;
//    }


}
