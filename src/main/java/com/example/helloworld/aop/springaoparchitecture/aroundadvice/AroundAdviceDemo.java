package com.example.helloworld.aop.springaoparchitecture.aroundadvice;

import org.springframework.aop.framework.ProxyFactory;

public class AroundAdviceDemo {
    public static void main(String[] args) {
        WorkerBean workerBean = getWorkerBean();
        workerBean.doSomeWork(10000);
    }

    private static WorkerBean getWorkerBean() {
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(new WorkerBean());
        proxyFactory.addAdvice(new WorkerInterceptor());
        return (WorkerBean) proxyFactory.getProxy();
    }
}