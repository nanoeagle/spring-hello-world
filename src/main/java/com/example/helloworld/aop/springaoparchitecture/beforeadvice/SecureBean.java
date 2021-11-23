package com.example.helloworld.aop.springaoparchitecture.beforeadvice;

public class SecureBean {
    public void writeSecureMessage() {
        System.out.println("This is an extremely secret message.");
    }
}