package com.example.helloworld.springboot;

import org.slf4j.*;
import org.springframework.stereotype.Component;

@Component
public class SpringBootDemoBean {
    private static Logger logger = 
        LoggerFactory.getLogger(SpringBootDemoBean.class);
    
    public void sayHi() {
        logger.info("Hello World!");
    }
}