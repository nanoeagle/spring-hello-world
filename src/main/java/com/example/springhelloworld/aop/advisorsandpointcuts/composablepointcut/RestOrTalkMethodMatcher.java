package com.example.springhelloworld.aop.advisorsandpointcuts.composablepointcut;

import java.lang.reflect.Method;

import org.springframework.aop.support.StaticMethodMatcher;

public class RestOrTalkMethodMatcher extends StaticMethodMatcher {
    @Override
    public boolean matches(Method method, Class<?> targetClass) {
        return method.getName().equals("rest") ||
            method.getName().equals("talk");
    }
}