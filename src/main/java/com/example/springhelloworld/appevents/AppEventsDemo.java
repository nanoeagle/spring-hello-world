package com.example.springhelloworld.appevents;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppEventsDemo {
    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppEventsConfig.class);

        MessageEventPublisher publisher = 
            context.getBean("publisher", MessageEventPublisher.class);
        publisher.publish("Hello!");
        publisher.publish("This is my first message to the world.");

        context.close();
    }
}