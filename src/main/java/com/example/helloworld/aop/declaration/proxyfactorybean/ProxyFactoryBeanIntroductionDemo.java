package com.example.helloworld.aop.declaration.proxyfactorybean;

import com.example.helloworld.aop.introduction.*;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ProxyFactoryBeanIntroductionDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx =
            new AnnotationConfigApplicationContext(
                ProxyFactoryBeanIntroductionConfig.class);

        Contact proxyContact = ctx.getBean("proxyContact", Contact.class);
        System.out.println("Is Contact? " + 
            (proxyContact instanceof Contact));
        System.out.println("Is IsModified? " + 
            (proxyContact instanceof IsModified));
        
        IsModified doubtedProxy = (IsModified) proxyContact;
        System.out.println("Has been modified? " + doubtedProxy.isModified());
        
        proxyContact.setName("Name 1");
        System.out.println("Has been modified? " + doubtedProxy.isModified());

        proxyContact.setName("Name 2");
        System.out.println("Has been modified? " + doubtedProxy.isModified());

        ctx.close();
    }
}