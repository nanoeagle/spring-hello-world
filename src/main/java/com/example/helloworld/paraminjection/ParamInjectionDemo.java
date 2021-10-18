package com.example.helloworld.paraminjection;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ParamInjectionDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(ParamInjectionConfig.class);
    
        Singer singer = context.getBean("singer", Singer.class);
        singer.sing();
		context.close();
    }
}