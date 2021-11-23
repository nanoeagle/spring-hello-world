package com.example.helloworld.aop.advisorsandpointcuts.dynamicpointcut;

import java.lang.reflect.Method;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.DynamicMethodMatcherPointcut;

public class SimpleDynamicPointcut extends DynamicMethodMatcherPointcut {
    @Override
    public ClassFilter getClassFilter() {
        return cls -> cls == SampleBean.class;
    }
    
    @Override
    public boolean matches(Method method, Class<?> targetClass) {
        String methodName = method.getName();
        System.out.println("Static check for " + methodName);
        return methodName.equals("foo");
    }

    @Override
    public boolean matches(Method method, Class<?> targetClass, Object... args) {
        System.out.println("Dynamic check for " + method.getName());
        return ((Integer) args[0]) != 100;
    }
}