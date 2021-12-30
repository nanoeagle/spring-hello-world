package com.example.springhelloworld.aop.introduction;

import java.lang.reflect.Method;
import java.util.*;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;

public class IsModifiedMixin extends DelegatingIntroductionInterceptor
implements IsModified {
    
    private boolean isModified;
    private Map<Method, Method> methodCache;
    
    public IsModifiedMixin() {
        isModified = false;
        methodCache = new HashMap<>();
    }

    @Override
    public boolean isModified() {
        return isModified;
    }

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        if (!isModified) processIfInvokedMethodIsSetter(invocation);
        return super.invoke(invocation);
    }

    private void processIfInvokedMethodIsSetter(MethodInvocation invocation) 
    throws Exception {
        if (isInvokedMethodSetter(invocation)) processIfGetterExists(invocation);
    }

    private boolean isInvokedMethodSetter(MethodInvocation invocation) {
        return invocation.getMethod().getName().startsWith("set")
            && invocation.getArguments().length == 1;
    }

    private void processIfGetterExists(MethodInvocation setterInvocation) 
    throws Exception {
        Method getter = findCorrespondingGetterTo(setterInvocation.getMethod());
        if (getter != null)
            determineWhetherObjectIsModifiedOrNot(setterInvocation, getter);
    }

    private Method findCorrespondingGetterTo(Method setter) {
        Method getter = methodCache.get(setter);
        if (getter != null) return getter;
        return retrieveGetterFromDeclaringClassOf(setter);
    }

    private Method retrieveGetterFromDeclaringClassOf(Method setter) {
        String getterName = setter.getName().replaceFirst("set", "get");
        try {
            Method getter = setter.getDeclaringClass().getMethod(getterName);
            synchronized (methodCache) { methodCache.put(setter, getter); }
            return getter;
        } catch (NoSuchMethodException e) { return null; }
    }

    private void determineWhetherObjectIsModifiedOrNot(
        MethodInvocation setterInvocation, Method getter) 
    throws Exception {
        Object newFieldValue = setterInvocation.getArguments()[0];
        Object oldFieldValue = getter.invoke(setterInvocation.getThis());
        
        if (newFieldValue == null && oldFieldValue == null) {
            isModified = false;
        } else if ((newFieldValue == null && oldFieldValue != null)
            || (newFieldValue != null && oldFieldValue == null)) {
            isModified = true;
        } else {
            isModified = !newFieldValue.equals(oldFieldValue);
        }
    }
}