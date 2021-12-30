package com.example.springhelloworld.springexpressionlanguage;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringExpressionLanguageDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(SpringExpressionLanguageConfig.class);
    
        SimpleValueInjectionSpEL svInjectionSpEL = context.getBean("valueInjectionSpEL", SimpleValueInjectionSpEL.class);
        System.out.println(svInjectionSpEL);
		context.close();
    }
}