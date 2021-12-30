package com.example.springhelloworld.aop.springaoparchitecture.beforeadvice;

import org.springframework.aop.framework.ProxyFactory;

public class SecurityDemo {
    public static void main(String[] args) {
        SecurityManager securityManager = new SecurityManager();
        SecureBean secureBean = getSecureBean();
        
        // 1st.
        try {
            secureBean.writeSecureMessage();
        } catch(SecurityException ex) {
            System.out.println("Exception Caught: " + ex.getMessage());
        }
        System.out.println();

        // 2nd.
        securityManager.login("superuser", "password");
        secureBean.writeSecureMessage();
        securityManager.logout();
        System.out.println();
        
        // 3rd.
        try {
            securityManager.login("user1", "pwd");
            secureBean.writeSecureMessage();
        } catch(SecurityException e) {
            System.out.println("Exception Caught: " + e.getMessage());
        } finally {
            securityManager.logout();
        }
    }

    private static SecureBean getSecureBean() {
        ProxyFactory factory = new ProxyFactory();
        factory.setTarget(new SecureBean());
        factory.addAdvice(new SecurityAdvice());
        return (SecureBean) factory.getProxy();
    }
}