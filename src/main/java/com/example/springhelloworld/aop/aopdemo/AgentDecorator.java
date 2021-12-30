package com.example.springhelloworld.aop.aopdemo;

import org.aopalliance.intercept.*;

public class AgentDecorator implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.print("James ");
        Object returnedValue = invocation.proceed();
        System.out.println("!");
        return returnedValue;
    }
}