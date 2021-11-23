package com.example.helloworld.aop.advisorsandpointcuts.annotationpointcut;

import com.example.helloworld.aop.advisorsandpointcuts.simplenamematching.GrammyGuitarist;
import com.example.helloworld.aop.advisorsandpointcuts.staticpointcut.SimpleAdvice;
import com.example.helloworld.contextaware.Guitar;

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