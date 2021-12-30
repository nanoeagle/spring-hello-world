package com.example.springhelloworld.autowiring;

import org.springframework.stereotype.Component;

@Component
public class FooImplOne implements Foo {
    public FooImplOne() {
        System.out.println("FooImplOne constructor.");
    }
    
    @Override
    public String toString() {
        return "FooImplOne";
    }
}