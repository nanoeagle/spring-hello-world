package com.example.springhelloworld.configprofiles;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ProfileDemo {
    public static void main(String[] args) throws Exception {
        // AnnotationConfigApplicationContext context = 
        //     new AnnotationConfigApplicationContext(ProfileConfig.class);
        AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(
                KindergardenProfileConfig.class, 
                HighschoolProfileConfig.class
            );

        FoodProviderService foodProvider =
            context.getBean("foodProvider", FoodProviderService.class);
        foodProvider.provideLunchSet();        
        context.close();
    }
}