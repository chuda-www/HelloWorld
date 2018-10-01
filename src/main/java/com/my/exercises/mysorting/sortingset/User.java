package com.my.exercises.mysorting.sortingset;

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

    public User(String name, int age) {
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

////        String[] name = {"Viktoryia","Denis","Viktor","Dmitry","Olga"};
////        int[] age = {35,36,25,32,37};


