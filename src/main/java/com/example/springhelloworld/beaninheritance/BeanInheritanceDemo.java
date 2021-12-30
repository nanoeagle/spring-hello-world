package com.example.springhelloworld.beaninheritance;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanInheritanceDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(BeanInheritanceConfig.class);
        
        Teacher parentTeacher = context.getBean("parentTeacher", Teacher.class);
        Teacher childTeacher = context.getBean("childTeacher", Teacher.class);

        System.out.println("Parent teacher:\n" + parentTeacher);        
        System.out.println("Child teacher:\n" + childTeacher);
        context.close();      
    }   
}