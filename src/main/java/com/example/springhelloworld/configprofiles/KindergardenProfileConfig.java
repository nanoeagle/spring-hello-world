package com.example.springhelloworld.configprofiles;

// import org.springframework.context.annotation.*;

// Specific profile is set by 
// "vmArgs": "-Dspring.profiles.active=kindergarden"
// in .vscode/launch.json.
// @Configuration
// @Profile("kindergarden")
public class KindergardenProfileConfig {
    // @Bean
    public FoodProviderService foodProvider() {
        return new KindergardenFoodProvider();
    }
}