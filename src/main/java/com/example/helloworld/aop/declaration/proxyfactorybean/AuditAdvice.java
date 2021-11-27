package com.example.helloworld.aop.declaration.proxyfactorybean;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class AuditAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] args, Object target) {
        System.out.println("\tExecuting: " + method.getName());
    }
}