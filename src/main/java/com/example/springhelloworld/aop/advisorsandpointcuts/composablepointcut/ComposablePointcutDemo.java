package com.example.springhelloworld.aop.advisorsandpointcuts.composablepointcut;

import com.example.springhelloworld.aop.advisorsandpointcuts.flowcontrolpointcut.SimpleBeforeAdvice2;
import com.example.springhelloworld.aop.advisorsandpointcuts.simplenamematching.GrammyGuitarist;
import com.example.springhelloworld.contextaware.Guitar;

import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.*;

public class ComposablePointcutDemo {
    public static void main(String[] args) {
        ComposablePointcut pointcut = 
            new ComposablePointcut(new SingMethodMatcher());
        demonstrateComposablePointcut(
            "Advise just 'sing' methods:", getProxy(pointcut));
        
        pointcut.union(new TalkMethodMatcher());
        demonstrateComposablePointcut(
            "Advise 'sing' and 'talk' methods:", getProxy(pointcut));

        pointcut.intersection(new RestOrTalkMethodMatcher());
        demonstrateComposablePointcut(
            "Advise 'rest' methods:", getProxy(pointcut));
    }

    private static GrammyGuitarist getProxy(ComposablePointcut pointcut) {
        Advisor advisor = new DefaultPointcutAdvisor(
            pointcut, new SimpleBeforeAdvice2());
        GrammyGuitarist guitarist = new GrammyGuitarist();
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.addAdvisor(advisor);
        proxyFactory.setTarget(guitarist);
        return (GrammyGuitarist) proxyFactory.getProxy();
    }

    private static void demonstrateComposablePointcut(
        String message, GrammyGuitarist proxy) {
        System.out.println(message + "\n------------------------");
        invokeProxyMethods(proxy);
        System.out.println("------------------------\n");
    }

    private static void invokeProxyMethods(GrammyGuitarist proxy) {
        proxy.sing();
        proxy.sing(new Guitar());
        proxy.rest();
        proxy.talk();
    }
}