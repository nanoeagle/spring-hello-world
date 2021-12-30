package com.example.springhelloworld.springboot;

import org.slf4j.*;
import org.springframework.stereotype.Component;

@Component
public class SpringBootDemoBean {
    private static final Logger LOGGER = 
        LoggerFactory.getLogger(SpringBootDemoBean.class);
    
    public void sayHi() {
        LOGGER.info("Hello World!");
    }
}