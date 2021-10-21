package com.example.helloworld.springawareness.contextawareness;

import org.springframework.context.annotation.*;

public class ContextAwarenessDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(ContextAwarenessConfig.class);
        
        // registered shutdown hook in ContextAwareBean.
		// context.close();
    }
}