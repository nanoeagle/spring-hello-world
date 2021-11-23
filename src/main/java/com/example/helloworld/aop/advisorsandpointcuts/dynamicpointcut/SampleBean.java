package com.example.helloworld.aop.advisorsandpointcuts.dynamicpointcut;

import com.example.helloworld.aop.advisorsandpointcuts.annotationpointcut.AdviceRequired;

@AdviceRequired
public class SampleBean {
    public void foo(int x) {
        System.out.println("Invoked foo() with: " + x);
    }
    
    public void bar() {
        System.out.println("Invoked bar()");
    }
}