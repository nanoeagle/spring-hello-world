package com.example.helloworld.autowiring;

import org.springframework.stereotype.Component;

@Component
public class FooImplThree implements Foo {
    public FooImplThree() {
        System.out.println("FooImplThree constructor.");
    }

    @Override
    public String toString() {
        return "FooImplThree";
    }
}