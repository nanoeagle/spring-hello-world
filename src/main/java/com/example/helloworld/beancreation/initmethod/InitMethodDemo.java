package com.example.helloworld.beancreation.initmethod;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class InitMethodDemo {
    public static void main(String[] args) {
        ApplicationContext context = 
            new AnnotationConfigApplicationContext(InitMethodConfig.class);
        
        Doctor doctor1 = context.getBean("doctor1", Doctor.class);
        System.out.println(doctor1);
        
        Doctor doctor2 = context.getBean("doctor2", Doctor.class);
        System.out.println(doctor2);
        
        Doctor doctor3 = context.getBean("doctor3", Doctor.class);
        System.out.println(doctor3);
    }
}