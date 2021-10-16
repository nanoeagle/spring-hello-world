package com.example.helloworld.beancreation.initinterface;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class InitInterfaceDemo {
    public static void main(String[] args) {
        ApplicationContext context = 
            new AnnotationConfigApplicationContext(InitInterfaceConfig.class);
        
        Dancer dancer1 = context.getBean("dancer1", Dancer.class);
        System.out.println(dancer1);
        
        Dancer dancer2 = context.getBean("dancer2", Dancer.class);
        System.out.println(dancer2);
        
        Dancer dancer3 = context.getBean("dancer3", Dancer.class);
        System.out.println(dancer3);
    }
}