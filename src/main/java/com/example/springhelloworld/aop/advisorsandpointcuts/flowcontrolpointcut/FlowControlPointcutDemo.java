package com.example.springhelloworld.aop.advisorsandpointcuts.flowcontrolpointcut;

import com.example.springhelloworld.aop.advisorsandpointcuts.dynamicpointcut.SampleBean;

import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.*;

public class FlowControlPointcutDemo {
    public static void main(String[] args) {
        Pointcut pc = new ControlFlowPointcut(
            FlowControlPointcutDemo.class, "test");
        
        ProxyFactory pf = new ProxyFactory();
        pf.setTarget(new SampleBean());
        pf.addAdvisor(new DefaultPointcutAdvisor(
            pc, new SimpleBeforeAdvice2()));

        SampleBean proxy = (SampleBean) pf.getProxy();
        System.out.println(
            "Trying normal invocation:");
        proxy.bar();
        proxy.foo(1);
        System.out.println(
            "Trying under FlowControlPointcutDemo.test():");
        test(proxy);
        test2(proxy);
    }

    private static void test(SampleBean proxy) {
        proxy.bar();
        proxy.foo(1);
    }
    private static void test2(SampleBean proxy) {
        proxy.bar();
        proxy.foo(1);
    }
}