package com.example.helloworld.springexpressionlanguage;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringExpressionLanguageDemo {
    public static void main(String[] args) {
        ApplicationContext context = 
            new AnnotationConfigApplicationContext(SpringExpressionLanguageConfig.class);
    
        SimpleValueInjectionSpEL svInjectionSpEL = context.getBean("valueInjectionSpEL", SimpleValueInjectionSpEL.class);
        System.out.println(svInjectionSpEL);
    }
}