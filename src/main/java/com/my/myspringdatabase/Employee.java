package com.my.myspringdatabase;

public class Employee {

    private String name;
    private Integer age;
    private Integer id;

//    public Employee(Integer id, String name, Integer age) {
//        this.name = name;
//        this.age = age;
//        this.id = id;
//    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getAge() {
        return age;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String toString() {
        return id + " " + name + " " + age;
    }
}
