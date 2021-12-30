package com.example.springhelloworld.beanlifecycle.beanlifecycleinterface;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BlcInterfaceDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(BlcInterfaceConfig.class);
        
        Dancer dancer1 = context.getBean("dancer1", Dancer.class);
        System.out.println(dancer1);
        
        Dancer dancer2 = context.getBean("dancer2", Dancer.class);
        System.out.println(dancer2);
        
        try {
            Dancer dancer3 = context.getBean("dancer3", Dancer.class);
            System.out.println(dancer3);
        } catch (Exception e) {
            System.out.println(e.getMessage());;
        }
		context.close();
    }
}