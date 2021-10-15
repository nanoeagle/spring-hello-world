package com.example.helloworld.beaninheritance;

public class Teacher {
    private String name;
    private String degree;
    private int age;

    public Teacher(String name) {
        this.name = name;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "\tName: " + name 
            + "\n\t" + "Degree: " + degree
            + "\n\t" + "Age: " + age;
    }
}