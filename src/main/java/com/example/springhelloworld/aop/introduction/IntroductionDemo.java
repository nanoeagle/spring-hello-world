package com.example.springhelloworld.aop.introduction;

import org.springframework.aop.framework.ProxyFactory;

public class IntroductionDemo {
    public static void main(String[] args) {
        Contact target = new Contact();
        target.setName("Name 1");

        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(target);
        proxyFactory.addAdvisor(new IsModifiedAdvisor());
        // to enforce the CGLIB proxy.
        proxyFactory.setOptimize(true);

        Contact proxy = (Contact) proxyFactory.getProxy();
        System.out.println("Is Contact? " + (proxy instanceof Contact));
        System.out.println("Is IsModified? " + (proxy instanceof IsModified));
        
        IsModified doubtedProxy = (IsModified) proxy;
        System.out.println("Has been modified? " + doubtedProxy.isModified());
        
        proxy.setName("Name 1");
        System.out.println("Has been modified? " + doubtedProxy.isModified());

        proxy.setName("Name 2");
        System.out.println("Has been modified? " + doubtedProxy.isModified());
    }
}