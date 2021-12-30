package com.example.springhelloworld.appevents;

import org.springframework.context.*;

public class MessageEventPublisher implements ApplicationContextAware {
    private ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext context) {
        this.context = context;
    }
    
    public void publish(String message) {
        context.publishEvent(new MessageEvent(this, message));
    }
}