package com.example.springhelloworld.autowiring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutowiringDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AutowiringConfig.class);

        Target t = null;

        // for xml.
        /* System.out.println("Using byName:\n");
        t = context.getBean("targetByName", Target.class);
        System.out.println("\nUsing byType:\n");
        t = context.getBean("targetByType", Target.class);
        System.out.println("\nUsing constructor:\n");
        t = context.getBean("targetConstructor", Target.class); */
        
        t = context.getBean(Target.class);
		context.close();
    }
}