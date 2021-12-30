package com.example.springhelloworld.methodreplacement;

import java.lang.reflect.Method;

import org.springframework.beans.factory.support.MethodReplacer;

public class FormatMessageReplacer implements MethodReplacer {

    @Override
    public Object reimplement(Object obj, Method method, Object[] args) {
        if (isFormatMessageMethod(method)) {
            return "<h2> " + obj + " </h2>";
        } else {
            throw new IllegalArgumentException(
                "Unable to reimplement method " + method.getName());
        }
    }

    private boolean isFormatMessageMethod(Method method) {
        if ( !method.getName().equals("formatMessage") ) {
            return false;
        }
        if (method.getParameterCount() != 1) {
            return false;
        }
        if (method.getParameterTypes()[0] != String.class) {
            return false;
        }
        return true;
    }
}