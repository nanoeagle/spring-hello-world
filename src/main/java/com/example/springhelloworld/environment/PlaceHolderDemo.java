package com.example.springhelloworld.environment;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PlaceHolderDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(PlaceHolderConfig.class);
        
        AppProperties appProperty = context.getBean(
            "appProperties", AppProperties.class);
        
        System.out.println("application.home: " + 
            appProperty.getApplicationHome());
        System.out.println("user.home: " + 
            appProperty.getUserHome());
        
        context.close();
    }
}