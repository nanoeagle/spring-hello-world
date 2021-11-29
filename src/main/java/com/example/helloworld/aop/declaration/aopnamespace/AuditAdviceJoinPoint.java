package com.example.helloworld.aop.declaration.aopnamespace;

import org.aspectj.lang.JoinPoint;

public class AuditAdviceJoinPoint {
    public void simpleBeforeAdvice(JoinPoint joinPoint) {
        System.out.println("Executing: " +
            joinPoint.getSignature().getDeclaringTypeName() + " " +
            joinPoint.getSignature().getName());
    }
}