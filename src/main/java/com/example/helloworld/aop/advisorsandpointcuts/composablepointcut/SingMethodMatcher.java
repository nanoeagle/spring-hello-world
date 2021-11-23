package com.example.helloworld.aop.advisorsandpointcuts.composablepointcut;

import java.lang.reflect.Method;

import org.springframework.aop.support.StaticMethodMatcher;

public class SingMethodMatcher extends StaticMethodMatcher {
    @Override
    public boolean matches(Method method, Class<?> targetClass) {
        return method.getName().startsWith("sing");
    }
}