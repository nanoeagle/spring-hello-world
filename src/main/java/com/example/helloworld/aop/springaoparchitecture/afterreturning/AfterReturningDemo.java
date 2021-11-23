package com.example.helloworld.aop.springaoparchitecture.afterreturning;

import org.springframework.aop.framework.ProxyFactory;

public class AfterReturningDemo {
    public static void main(String[] args) {
        KeyGenerator keyGenerator = getKeyGenerator();
        for (int i = 0; i < 10; i++) {
            try {
                System.out.println(keyGenerator.getKey());
            } catch (SecurityException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static KeyGenerator getKeyGenerator() {
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(new KeyGenerator());
        proxyFactory.addAdvice(new WeakKeyCheckAdvice());
        return (KeyGenerator) proxyFactory.getProxy();
    }
}