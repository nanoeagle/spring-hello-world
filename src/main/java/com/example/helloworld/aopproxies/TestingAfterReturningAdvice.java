package com.example.helloworld.aopproxies;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

public class TestingAfterReturningAdvice implements AfterReturningAdvice {
    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) 
    throws Throwable {}
}