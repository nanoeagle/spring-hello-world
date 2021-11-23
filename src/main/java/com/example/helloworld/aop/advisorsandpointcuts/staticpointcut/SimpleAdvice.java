package com.example.helloworld.aop.advisorsandpointcuts.staticpointcut;

import org.aopalliance.intercept.*;

public class SimpleAdvice implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("Invoking the method '" + 
            invocation.getMethod().getName() + "' of the class " +
            invocation.getThis().getClass().getName() + ":");
        Object value = invocation.proceed();
        System.out.println("Done!\n");
        return value;
    }
}