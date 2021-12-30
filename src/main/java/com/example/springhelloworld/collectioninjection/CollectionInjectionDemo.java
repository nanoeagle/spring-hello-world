package com.example.springhelloworld.collectioninjection;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CollectionInjectionDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(CollectionInjectionConfig.class);
    
        CollectionInjection collectionInjection = 
            context.getBean("injectCollection", CollectionInjection.class);
        collectionInjection.displayInfo();  
		context.close();
    }
}