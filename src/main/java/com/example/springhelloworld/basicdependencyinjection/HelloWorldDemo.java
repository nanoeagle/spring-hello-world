package com.example.springhelloworld.basicdependencyinjection;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HelloWorldDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(HelloWorldConfig.class);
        MessageRenderer renderer = context.getBean("renderer", MessageRenderer.class);
        renderer.render();
		context.close();
    }
}