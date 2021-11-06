package com.example.helloworld.beanlifecycle.beanlifecyclejsr250anno;

import javax.annotation.*;

public class DoctorWithJSR250Anno {
    private static final String DEFAULT_NAME = "Eric Clapton";
    
    private String name;
    private int age;

    public DoctorWithJSR250Anno() {
        System.out.println("A new Doctor object has been created.");
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @PostConstruct
    public void init() {
        System.out.println("Initializing bean");
        
        if (name == null) {
            System.out.println("Using default name");
            name = DEFAULT_NAME;
        }
        if (age == 0) {
            throw new IllegalArgumentException(
                "You must set the age property of any beans of type " 
                + DoctorWithJSR250Anno.class);
        }
    }

    @PreDestroy
    public void destroy() throws Exception {
        System.out.println("Destroying bean " + name + ".");
    }

    @Override
    public String toString() {
        return "\tName: " + name + "\n\tAge: " + age;
    }
}