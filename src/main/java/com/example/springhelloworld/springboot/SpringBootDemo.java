package com.example.springhelloworld.springboot;

import java.util.Arrays;

import org.slf4j.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringBootDemo {
    private static final Logger LOGGER = 
        LoggerFactory.getLogger(SpringBootDemo.class);

    public static void main(String[] args) {
        ConfigurableApplicationContext context = 
            SpringApplication.run(SpringBootDemo.class, args);
        assert context != null;
        
        LOGGER.info("The beans you were looking for:");
        Arrays.stream(context.getBeanDefinitionNames())
            .forEach(LOGGER::info);
        
        context.getBean(SpringBootDemoBean.class).sayHi();
        context.close();
    }
}