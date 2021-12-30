package com.example.springhelloworld.springawareness.beanawareness;

import org.springframework.beans.factory.BeanNameAware;

public class NamedDoctor implements BeanNameAware {
    private String name;

    /**
     * @Implements {@link BeanNameAware#setBeanName(String)}
     */
    @Override
    public void setBeanName(String name) {
        this.name = name;
    }

    public void showName() {
        System.out.println("Doctor " + name);
    }
}