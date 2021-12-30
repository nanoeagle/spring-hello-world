package com.example.springhelloworld.aop.advisorsandpointcuts.regexmatching;

import com.example.springhelloworld.aop.advisorsandpointcuts.simplenamematching.GrammyGuitarist;
import com.example.springhelloworld.aop.advisorsandpointcuts.staticpointcut.SimpleAdvice;
import com.example.springhelloworld.contextaware.Guitar;

import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.*;

public class AspectJRegexMatchingDemo {
    public static void main(String[] args) {
        AspectJExpressionPointcut methodPointcut =
            new AspectJExpressionPointcut();
        methodPointcut.setExpression("execution(* sing*(..))");
        
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