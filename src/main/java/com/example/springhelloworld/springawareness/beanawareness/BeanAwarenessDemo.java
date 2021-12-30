package com.example.springhelloworld.springawareness.beanawareness;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanAwarenessDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(BeanAwarenessConfig.class);
        
        context.getBean("johnMayer", NamedDoctor.class).showName();

		context.close();
    }
}