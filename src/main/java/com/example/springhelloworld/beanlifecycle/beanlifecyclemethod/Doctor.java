package com.example.springhelloworld.beanlifecycle.beanlifecyclemethod;

public class Doctor {
    private static final String DEFAULT_NAME = "Eric Clapton";
    
    private String name;
    private int age;

    public Doctor() {
        System.out.println("A new Doctor object has been created.");
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void init() {
        System.out.println("Initializing bean");
        
        if (name == null) {
            System.out.println("Using default name");
            name = DEFAULT_NAME;
        }
        if (age == 0) {
            throw new IllegalArgumentException(
                "You must set the age property of any beans of type " 
                + Doctor.class);
        }
    }

    public void destroy() {
        System.out.println("Destroying bean " + name + ".");
    }

    @Override
    public String toString() {
        return "\tName: " + name + "\n\tAge: " + age;
    }
}