package com.example.springhelloworld.beanfactory;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanFactoryDemo {
    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(BeanFactoryConfig.class);

        // notice the ampersand in &shaMesDigest bean name.
        // get a FactoryBean directly.
        // MessageDigestFactoryBean mBean = 
        //     context.getBean("&shaMesDigest", MessageDigestFactoryBean.class);
        // System.out.println(mBean.getObjectType());
        
        MessageDigester mesDigester = 
            context.getBean("mesDigester", MessageDigester.class);
        mesDigester.digest("Are you ok?");

        context.close();
    }
}