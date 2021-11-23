package com.example.helloworld.aop.springaoparchitecture.aroundadvice;

import org.aopalliance.intercept.*;
import org.springframework.util.StopWatch;

public class WorkerInterceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start(invocation.getMethod().getName());

        Object returnedValue = invocation.proceed();
        
        stopWatch.stop();
        recordInfo(invocation, stopWatch.getTotalTimeMillis());
        return returnedValue;
    }

    private void recordInfo(MethodInvocation invocation, long totalTimeMillis) {
        Object target = invocation.getThis();

        System.out.println("Executed method: " + 
            invocation.getMethod().getName());
        System.out.println("On object of type: " + 
            target.getClass().getName());
        System.out.print("With arguments: ");
        for (Object arg : invocation.getArguments()) {
            System.out.print(arg + " ");
        }
        System.out.println();
        System.out.println("Took: " + totalTimeMillis);
    }
}