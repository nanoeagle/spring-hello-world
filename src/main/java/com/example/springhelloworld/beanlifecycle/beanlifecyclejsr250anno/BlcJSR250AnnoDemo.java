package com.example.springhelloworld.beanlifecycle.beanlifecyclejsr250anno;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BlcJSR250AnnoDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(BlcJSR250AnnoConfig.class);
        
        DoctorWithJSR250Anno doctor1 = context.getBean("doctor1", DoctorWithJSR250Anno.class);
        System.out.println(doctor1);
        
        DoctorWithJSR250Anno doctor2 = context.getBean("doctor2", DoctorWithJSR250Anno.class);
        System.out.println(doctor2);
        
        try {
            DoctorWithJSR250Anno doctor3 = context.getBean("doctor3", DoctorWithJSR250Anno.class);
            System.out.println(doctor3);
        } catch (Exception e) {
            System.out.println(e.getMessage());;
        }

		context.close();
    }
}