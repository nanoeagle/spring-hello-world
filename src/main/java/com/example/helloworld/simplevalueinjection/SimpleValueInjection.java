package com.example.helloworld.simplevalueinjection;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("valueInjection")
public class SimpleValueInjection {
    @Value("John Mayer")
    private String name;
    @Value("39")
    private int age;
    @Value("1.92")
    private float height;
    @Value("false")
    private boolean programmer;
    @Value("1241401112")
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