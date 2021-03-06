package com.example.springhelloworld.aop.springaoparchitecture.beforeadvice;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class SimpleBeforeAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] args, Object target) 
    throws Throwable {
        System.out.println(
            "Before '" + method.getName() + "' the song " +
            args[0] + ", tune guitar.");
    }
}