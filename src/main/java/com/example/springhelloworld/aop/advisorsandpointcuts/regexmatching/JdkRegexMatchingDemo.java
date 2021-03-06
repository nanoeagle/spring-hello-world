package com.example.springhelloworld.aop.advisorsandpointcuts.regexmatching;

import com.example.springhelloworld.aop.advisorsandpointcuts.simplenamematching.GrammyGuitarist;
import com.example.springhelloworld.aop.advisorsandpointcuts.staticpointcut.SimpleAdvice;
import com.example.springhelloworld.contextaware.Guitar;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.*;

public class JdkRegexMatchingDemo {
    public static void main(String[] args) {
        JdkRegexpMethodPointcut methodPointcut =
            new JdkRegexpMethodPointcut();
        methodPointcut.setPattern(".*sing.*");
        
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