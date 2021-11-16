package com.example.helloworld.advisorsandpointcuts.simplenamematching;

import com.example.helloworld.advisorsandpointcuts.staticpointcut.SimpleAdvice;
import com.example.helloworld.contextaware.Guitar;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.*;

public class SimpleNameMatchingDemo {
    public static void main(String[] args) {
        NameMatchMethodPointcut methodPointcut = 
            new NameMatchMethodPointcut();
        methodPointcut.addMethodName("sing");
        methodPointcut.addMethodName("rest");

        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(new GrammyGuitarist());
        proxyFactory.addAdvisor(new DefaultPointcutAdvisor(
            methodPointcut, new SimpleAdvice()));
        
        GrammyGuitarist guitarist = 
            (GrammyGuitarist) proxyFactory.getProxy();
        guitarist.sing();
        guitarist.sing(new Guitar());
        guitarist.rest();
        guitarist.talk();
    }    
}