package com.example.springhelloworld.aop.advisorsandpointcuts.staticpointcut;

import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

public class StaticPointcutDemo {
    public static void main(String[] args) {
        Advisor advisor = new DefaultPointcutAdvisor(
            new SimpleStaticPointcut(), new SimpleAdvice());
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.addAdvisor(advisor);

        proxyFactory.setTarget(new GoodGuitarist());
        GoodGuitarist goodGuitarist = (GoodGuitarist) proxyFactory.getProxy();
        goodGuitarist.sing();

        proxyFactory.setTarget(new GreatGuitarist());
        GreatGuitarist greatGuitarist = (GreatGuitarist) proxyFactory.getProxy();
        greatGuitarist.sing();
    }
}