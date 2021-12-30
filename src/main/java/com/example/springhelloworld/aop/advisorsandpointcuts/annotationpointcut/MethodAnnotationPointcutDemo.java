package com.example.springhelloworld.aop.advisorsandpointcuts.annotationpointcut;

import com.example.springhelloworld.aop.advisorsandpointcuts.simplenamematching.GrammyGuitarist;
import com.example.springhelloworld.aop.advisorsandpointcuts.staticpointcut.SimpleAdvice;
import com.example.springhelloworld.contextaware.Guitar;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.annotation.AnnotationMatchingPointcut;

public class MethodAnnotationPointcutDemo {
    public static void main(String[] args) {
        AnnotationMatchingPointcut pointcut = AnnotationMatchingPointcut
            .forMethodAnnotation(AdviceRequired.class);
        
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.addAdvisor(new DefaultPointcutAdvisor(
            pointcut, new SimpleAdvice()));
        proxyFactory.setTarget(new GrammyGuitarist());

        GrammyGuitarist guitaristProxy = 
            (GrammyGuitarist) proxyFactory.getProxy();
        guitaristProxy.sing(new Guitar());
        guitaristProxy.rest();
    }
}