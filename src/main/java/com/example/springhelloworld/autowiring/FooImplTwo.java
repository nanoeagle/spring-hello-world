package com.example.springhelloworld.autowiring;

// import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
// @Primary
public class FooImplTwo implements Foo {
    public FooImplTwo() {
        System.out.println("FooImplTwo constructor.");
    }

    @Override
    public String toString() {
        return "FooImplTwo";
    }
}