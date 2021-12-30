package com.example.springhelloworld.springexpressionlanguage;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("valueInjectionSpEL")
public class SimpleValueInjectionSpEL {
    @Value("#{valueInjectionConfig.name}")
    private String name;
    @Value("#{valueInjectionConfig.age + 1}")
    private int age;
    @Value("#{valueInjectionConfig.height}")
    private float height;
    @Value("#{valueInjectionConfig.programmer}")
    private boolean programmer;
    @Value("#{valueInjectionConfig.ageInSeconds}")
    private Long ageInSeconds;
 
    // just need when injected by external file.
    // public void setName(String name) { this.name = name; }
    // public void setAge(int age) { this.age = age; }
    // public void setHeight(float height) { this.height = height; }
    // public void setProgrammer(boolean programmer) { this.programmer = programmer; }
    // public void setAgeInSeconds(Long ageInSeconds) { this.ageInSeconds = ageInSeconds; }
    
    @Override
    public String toString() {
        return "Name: " + name + "\n"
            + "Age: " + age + "\n"
            + "Age in Seconds: " + ageInSeconds + "\n"
            + "Height: " + height + "\n"
            + "Is Programmer?: " + programmer;
    }
}