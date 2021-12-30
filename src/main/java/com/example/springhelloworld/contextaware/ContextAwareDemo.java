package com.example.springhelloworld.contextaware;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ContextAwareDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(ContextAwareConfig.class);

        Musician musician = context.getBean("johnMayer", Musician.class);
        musician.playInstrument();
		context.close();
    }
}