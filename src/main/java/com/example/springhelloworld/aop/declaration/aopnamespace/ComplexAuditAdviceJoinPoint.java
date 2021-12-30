package com.example.springhelloworld.aop.declaration.aopnamespace;

import com.example.springhelloworld.contextaware.Guitar;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class ComplexAuditAdviceJoinPoint {
    public void simpleBeforeAdvice(JoinPoint joinPoint, Guitar guitar) {
        if (guitar.getBrand().equals("Gibson")) {
            System.out.println("Executing: " +
                joinPoint.getSignature().getDeclaringTypeName() + " " +
                joinPoint.getSignature().getName());
        }
    }

    public Object simpleAroundAdvice(ProceedingJoinPoint pjp, Guitar guitar) 
    throws Throwable {
        System.out.println("Before execution: " +
            pjp.getSignature().getDeclaringTypeName() + " " +
            pjp.getSignature().getName() +
            " argument: guitar " + guitar.getBrand());
        Object returnedVal = pjp.proceed();
        System.out.println("After execution: " +
            pjp.getSignature().getDeclaringTypeName() + " " +
            pjp.getSignature().getName() +
            " argument: guitar " + guitar.getBrand());
        return returnedVal;
    }
}