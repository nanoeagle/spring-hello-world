package com.example.springhelloworld.aop.aopdemo;

import org.springframework.aop.framework.ProxyFactory;

public class AOPDemo {
    public static void main(String[] args) {
        Agent agent = new Agent();
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.addAdvice(new AgentDecorator());
        proxyFactory.setTarget(agent);
        Agent proxy = (Agent) proxyFactory.getProxy();
        
        agent.speak();
        System.out.println();
        proxy.speak();
    }
}