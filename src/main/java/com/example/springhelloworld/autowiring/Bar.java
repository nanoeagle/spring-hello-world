package com.example.springhelloworld.autowiring;

import org.springframework.stereotype.Component;

@Component
public class Bar {
    public Bar() {
        System.out.println("Bar constructor.");
    }
}