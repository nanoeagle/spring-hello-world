package com.example.helloworld.aopproxies;

import java.lang.reflect.Method;

import org.springframework.aop.Advisor;
import org.springframework.aop.framework.*;
import org.springframework.aop.support.DefaultPointcutAdvisor;

public class ProxyPerformanceTest {
    public static void main(String[] args) {
        SimpleBean target = new DefaultSimpleBean();
        Advisor advisor = new DefaultPointcutAdvisor(
            new TestingPointcut(), new TestingBeforeAdvice());
        
        try {
            runCglibTests(target, advisor);
            runCglibFrozenTests(target, advisor);
            runJdkTests(target, advisor);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void runCglibTests(SimpleBean target, Advisor advisor) 
    throws Exception {
        ProxyFactory proxyFactory = createProxyFactory(target, advisor);
        proxyFactory.setProxyTargetClass(true);
        SimpleBean proxy = (SimpleBean) proxyFactory.getProxy();
        System.out.println("\nRunning CGLIB (Standard) Tests");
        System.out.println("--------------------------------");
        System.out.println(proxy.getClass());
        test(proxy);
    }
    
    private static void runCglibFrozenTests(SimpleBean target, Advisor advisor) 
    throws Exception {
        ProxyFactory proxyFactory = createProxyFactory(target, advisor);
        proxyFactory.setProxyTargetClass(true);
        proxyFactory.setFrozen(true);
        // the statement below causes an exception.
        // proxyFactory.addAdvice(new TestingAfterReturningAdvice());
        SimpleBean proxy = (SimpleBean) proxyFactory.getProxy();
        System.out.println("\nRunning CGLIB (Frozen) Tests");
        System.out.println("--------------------------------");
        System.out.println(proxy.getClass());
        test(proxy);
    }
    
    private static void runJdkTests(SimpleBean target, Advisor advisor) 
    throws Exception {
        ProxyFactory proxyFactory = createProxyFactory(target, advisor);
        proxyFactory.setInterfaces(SimpleBean.class);
        SimpleBean proxy = (SimpleBean) proxyFactory.getProxy();
        System.out.println("\nRunning JDK Tests");
        System.out.println("--------------------------------");
        System.out.println(proxy.getClass());
        test(proxy);
    }

    public static ProxyFactory createProxyFactory(SimpleBean target, Advisor advisor) {
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(target);
        proxyFactory.addAdvisor(advisor);
        return proxyFactory;
    }

    private static void test(SimpleBean bean) 
    throws Exception {
        String[] methodNames = {"advised", "unadvised", "hashCode"};
        for (String methodName : methodNames) {
            System.out.println("Testing " + methodName + "() method:");
            invokeMethodOnObject(bean.getClass().getMethod(methodName), bean);
        }
        
        System.out.println("Testing equals() method:");
            invokeMethodOnObject(
                bean.getClass().getMethod("equals", Object.class), bean, bean);

        Advised advisedBean = (Advised) bean;
        System.out.println("Testing getTargetClass() method:");
        invokeMethodOnObject(
            Advised.class.getMethod("getTargetClass"), advisedBean);
        System.out.println("--------------------------------");
    }

    private static void invokeMethodOnObject(Method method, Object obj, 
        Object... args) 
    throws Exception {
        long before = 0;
        long after = 0;
        before = System.currentTimeMillis();
        for(int x = 0; x < 500000; x++) method.invoke(obj, args);
        after = System.currentTimeMillis();
        System.out.println("\tTook " + (after - before) + " ms");
    }
}