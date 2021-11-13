package com.example.helloworld.springaoparchitecture.throwsadvice;

import org.springframework.aop.framework.ProxyFactory;

public class ThrowsAdviceDemo {
    public static void main(String[] args) {
        ErrorBean errorBean = getErrorBean();
        try { errorBean.errorProneMethod(); } 
        catch (Exception e) {}
            
        try { errorBean.otherErrorProneMethod(); } 
        catch (Exception e) {}

        errorBean.notErrorProneMethod();
    }

    private static ErrorBean getErrorBean() {
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(new ErrorBean());
        proxyFactory.addAdvice(new SimpleThrowsAdvice());
        return (ErrorBean) proxyFactory.getProxy();
    }
}