package com.example.springhelloworld.aop.declaration.aspectjstyle;

import com.example.springhelloworld.contextaware.Guitar;

import org.aspectj.lang.*;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AnnotatedAdvice {
    @Pointcut("execution(* sing*(com.example.springhelloworld.contextaware.Guitar))"
        + " && args(guitar)")
    public void singExecution(Guitar guitar) {}
    
    @Pointcut("bean(guitarist)")
    public void isGuitarist() {}

    @Before("singExecution(guitar) && isGuitarist()")
    public void simpleBeforeAdvice(JoinPoint joinPoint, Guitar guitar) {
        if (guitar.getBrand().equals("Gibson")) {
            System.out.println("Executing: " +
                joinPoint.getSignature().getDeclaringTypeName() + " " +
                joinPoint.getSignature().getName());
        }
    }

    @Around("singExecution(guitar) && isGuitarist()")
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