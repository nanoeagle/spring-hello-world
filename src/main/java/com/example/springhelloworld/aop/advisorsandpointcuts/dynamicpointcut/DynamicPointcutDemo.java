package com.example.springhelloworld.aop.advisorsandpointcuts.dynamicpointcut;

import com.example.springhelloworld.aop.advisorsandpointcuts.staticpointcut.SimpleAdvice;

import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

public class DynamicPointcutDemo {
    public static void main(String[] args) {
        Advisor advisor = new DefaultPointcutAdvisor(
            new SimpleDynamicPointcut(), new SimpleAdvice());
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.addAdvisor(advisor);
        proxyFactory.setTarget(new SampleBean());
        SampleBean sampleBeanProxy = (SampleBean) proxyFactory.getProxy();
        
        sampleBeanProxy.foo(1);
        sampleBeanProxy.foo(12);
        sampleBeanProxy.foo(100);

        sampleBeanProxy.bar();
        sampleBeanProxy.bar();
    }
}