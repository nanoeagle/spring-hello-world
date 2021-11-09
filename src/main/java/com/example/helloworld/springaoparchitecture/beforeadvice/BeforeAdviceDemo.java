package com.example.helloworld.springaoparchitecture.beforeadvice;

import org.springframework.aop.framework.ProxyFactory;

public class BeforeAdviceDemo {
    public static void main(String[] args) {
        Guitarist guitarist = new Guitarist();

        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.addAdvice(new SimpleBeforeAdvice());
        proxyFactory.setTarget(guitarist);

        Guitarist guitaristProxy = (Guitarist) proxyFactory.getProxy();
        guitaristProxy.sing("Happy Birthday");
    }
}