package com.example.helloworld.springaoparchitecture.beforeadvice;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class SecurityAdvice implements MethodBeforeAdvice {
    private SecurityManager securityManager;
    
    public SecurityAdvice() {
        this.securityManager = new SecurityManager();
    }

    @Override
    public void before(Method method, Object[] args, Object target) 
    throws Throwable {
        UserInfo user = securityManager.getLoggedInUser();
        if (user == null) {
            System.out.println("No user authenticated.");
            throw new SecurityException(
                "You must login before attempting to invoke the method: "
                + method.getName());
        
        } else if (
            user.getUserName().equals("superuser") &&
            user.getPassword().equals("password")
        ) {
            System.out.println("Logged in user is 'superuser' - OKAY.");
        
        } else {
            System.out.println("Logged in user is '" + user.getUserName()
                + "' - NOT ALLOWED.");
            throw new SecurityException("User '" + user.getUserName() 
                + "' is not allowed to access the method " 
                + method.getName());
        }
    }
}