package com.example.springhelloworld.aop.advisorsandpointcuts.dynamicpointcut;

import com.example.springhelloworld.aop.advisorsandpointcuts.annotationpointcut.AdviceRequired;

@AdviceRequired
public class SampleBean {
    public void foo(int x) {
        System.out.println("Invoked foo() with: " + x);
    }
    
    public void bar() {
        System.out.println("Invoked bar()");
    }
}