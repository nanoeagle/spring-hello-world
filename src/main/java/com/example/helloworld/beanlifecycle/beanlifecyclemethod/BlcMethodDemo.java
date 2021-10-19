package com.example.helloworld.beanlifecycle.beanlifecyclemethod;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BlcMethodDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(BlcMethodConfig.class);
        
        Doctor doctor1 = context.getBean("doctor1", Doctor.class);
        System.out.println(doctor1);
        
        Doctor doctor2 = context.getBean("doctor2", Doctor.class);
        System.out.println(doctor2);
        
        try {
            Doctor doctor3 = context.getBean("doctor3", Doctor.class);
            System.out.println(doctor3);
        } catch (Exception e) {
            System.out.println(e.getMessage());;
        }

		context.close();
    }
}