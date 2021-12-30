package com.example.springhelloworld.configprofiles;

// import org.springframework.context.annotation.*;

// Specific profile is set by 
// "vmArgs": "-Dspring.profiles.active=highschool"
// in .vscode/launch.json.
// @Configuration
// @Profile("highschool")
public class HighschoolProfileConfig {
    // @Bean
    public FoodProviderService foodProvider() {
        return new HighschoolFoodProvider();
    }
}