package com.example.helloworld.contextaware;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ContextAwareDemo {
    public static void main(String[] args) {
        ApplicationContext context = 
            new AnnotationConfigApplicationContext(ContextAwareConfig.class);

        Musician musician = context.getBean("johnMayer", Musician.class);
        musician.playInstrument();
    }
}