package com.example.springhelloworld.beanlifecycle.beanlifecycleinterface;

import org.springframework.beans.factory.*;

public class Dancer implements InitializingBean, DisposableBean {
    private static final String DEFAULT_NAME = "Eric Clapton";
    
    private String name;
    private int age;

    public Dancer() {
        System.out.println("A new Dancer object has been created.");
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Initializing bean");
        
        if (name == null) {
            System.out.println("Using default name");
            name = DEFAULT_NAME;
        }
        if (age == 0) {
            throw new IllegalArgumentException(
                "You must set the age property of any beans of type " 
                + Dancer.class);
        }
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Destroying bean " + name + ".");
    }

    @Override
    public String toString() {
        return "\tName: " + name + "\n\tAge: " + age;
    }
}