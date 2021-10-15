package com.example.helloworld.collectioninjection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CollectionInjectionDemo {
    public static void main(String[] args) {
        ApplicationContext context = 
            new AnnotationConfigApplicationContext(CollectionInjectionConfig.class);
    
        CollectionInjection collectionInjection = 
            context.getBean("injectCollection", CollectionInjection.class);
        collectionInjection.displayInfo();  
    }
}