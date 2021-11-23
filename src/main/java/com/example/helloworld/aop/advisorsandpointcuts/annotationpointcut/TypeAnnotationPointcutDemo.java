package com.example.helloworld.aop.advisorsandpointcuts.annotationpointcut;

import com.example.helloworld.aop.advisorsandpointcuts.dynamicpointcut.SampleBean;
import com.example.helloworld.aop.advisorsandpointcuts.staticpointcut.SimpleAdvice;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.annotation.AnnotationMatchingPointcut;

public class TypeAnnotationPointcutDemo {
    public static void main(String[] args) {
        AnnotationMatchingPointcut pointcut = 
            new AnnotationMatchingPointcut(AdviceRequired.class);

        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.addAdvisor(new DefaultPointcutAdvisor(
            pointcut, new SimpleAdvice()));
        proxyFactory.setTarget(new SampleBean());

        SampleBean beanProxy = (SampleBean) proxyFactory.getProxy();
        beanProxy.foo(10);
        beanProxy.bar();
    }
}