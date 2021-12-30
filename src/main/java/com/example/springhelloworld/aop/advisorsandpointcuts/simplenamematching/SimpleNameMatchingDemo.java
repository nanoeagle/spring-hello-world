package com.example.springhelloworld.aop.advisorsandpointcuts.simplenamematching;

import com.example.springhelloworld.aop.advisorsandpointcuts.staticpointcut.SimpleAdvice;
import com.example.springhelloworld.contextaware.Guitar;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.*;

public class SimpleNameMatchingDemo {
    public static void main(String[] args) {
        NameMatchMethodPointcut methodPointcut = 
            new NameMatchMethodPointcut();
        methodPointcut.addMethodName("sing");
        methodPointcut.addMethodName("rest");

        ProxyFactory proxyFactory1 = new ProxyFactory();
        proxyFactory1.setTarget(new GrammyGuitarist());
        proxyFactory1.addAdvisor(new DefaultPointcutAdvisor(
            methodPointcut, new SimpleAdvice()));

        GrammyGuitarist guitarist1 = 
            (GrammyGuitarist) proxyFactory1.getProxy();
        guitarist1.sing();
        guitarist1.sing(new Guitar());
        guitarist1.rest();
        guitarist1.talk();

        // or ----------------------
        System.out.println("\nor ----------------------\n");

        NameMatchMethodPointcutAdvisor advisor = 
            new NameMatchMethodPointcutAdvisor(new SimpleAdvice());
        advisor.addMethodName("sing");
        advisor.addMethodName("rest");

        ProxyFactory proxyFactory2 = new ProxyFactory();
        proxyFactory2.setTarget(new GrammyGuitarist());
        proxyFactory2.addAdvisor(advisor);

        GrammyGuitarist guitarist2 = 
            (GrammyGuitarist) proxyFactory2.getProxy();
        guitarist2.sing();
        guitarist2.sing(new Guitar());
        guitarist2.rest();
        guitarist2.talk();
    }
}