package com.example.helloworld.environment;

import java.util.*;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.*;

public class EnvironmentDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext();
        ConfigurableEnvironment env = context.getEnvironment();
        MutablePropertySources propertySources = env.getPropertySources();

        Map<String,Object> appMap = new HashMap<>();
        appMap.put("user.home", "application_home");
        propertySources.addFirst(new MapPropertySource("appProperties", appMap));

        System.out.println("System user.home: " + System.getProperty("user.home"));
        System.out.println("System JAVA_HOME: " + System.getenv("JAVA_HOME"));

        System.out.println("Environment user.home: " + env.getProperty("user.home"));
        System.out.println("Environment JAVA_HOME: " + env.getProperty("JAVA_HOME"));

        context.close();
    }
}