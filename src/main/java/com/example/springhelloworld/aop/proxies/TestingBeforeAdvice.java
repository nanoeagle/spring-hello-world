package com.example.springhelloworld.aop.proxies;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class TestingBeforeAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] args, Object target) 
    throws Throwable {}
}