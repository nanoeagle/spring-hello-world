package com.example.helloworld.aop.advisorsandpointcuts.staticpointcut;

import java.lang.reflect.Method;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.StaticMethodMatcherPointcut;

public class SimpleStaticPointcut extends StaticMethodMatcherPointcut {
    @Override
    public ClassFilter getClassFilter() {
        return cls -> cls == GoodGuitarist.class;
    }
    
    @Override
    public boolean matches(Method method, Class<?> targetClass) {
        return method.getName().equals("sing");
    }
}