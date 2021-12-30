package com.example.springhelloworld.aop.springaoparchitecture.beforeadvice;

import org.springframework.aop.framework.ProxyFactory;

public class BeforeAdviceDemo {
    public static void main(String[] args) {
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.addAdvice(new SimpleBeforeAdvice());
        proxyFactory.setTarget(new Guitarist());

        Guitarist guitaristProxy = (Guitarist) proxyFactory.getProxy();
        guitaristProxy.sing("Happy Birthday");
    }
}