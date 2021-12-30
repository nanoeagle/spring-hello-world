package com.example.springhelloworld.simplevalueinjection;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SimpleValueInjectionDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(SimpleValueInjectionConfig.class);
    
        SimpleValueInjection svInjection = context.getBean("valueInjection", SimpleValueInjection.class);
        System.out.println(svInjection);
		context.close();
    }
}