package com.example.helloworld.springboot;

import java.util.Arrays;

import org.slf4j.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringBootDemo {
    private static Logger logger = 
        LoggerFactory.getLogger(SpringBootDemo.class);

    public static void main(String[] args) {
        ConfigurableApplicationContext context = 
            SpringApplication.run(SpringBootDemo.class, args);
        assert context != null;
        
        logger.info("The beans you were looking for:");
        Arrays.stream(context.getBeanDefinitionNames())
            .forEach(logger::info);
        
        context.getBean(SpringBootDemoBean.class).sayHi();
        context.close();
    }
}