package com.example.helloworld.aop.advisorsandpointcuts.flowcontrolpointcut;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class SimpleBeforeAdvice2 implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] args, Object target) 
    throws Throwable {
        System.out.println("Before method: " + method);
    }
}