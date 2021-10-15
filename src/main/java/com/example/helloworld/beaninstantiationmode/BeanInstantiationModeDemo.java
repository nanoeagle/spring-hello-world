package com.example.helloworld.beaninstantiationmode;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanInstantiationModeDemo {
    public static void main(String[] args) {
        ApplicationContext context = 
            new AnnotationConfigApplicationContext(BeanInstantiationModeConfig.class);
    
        Worker worker1 = context.getBean("nonSingleton", Worker.class);
        Worker worker2 = context.getBean("nonSingleton", Worker.class);
        compareWorkers(worker1, worker2);
    }

    private static void compareWorkers(Worker worker1, Worker worker2) {
        System.out.println("Identity Equal? " + (worker1 == worker2));
        System.out.println("Value Equal? " + worker1.equals(worker2));
        System.out.println(worker1);
        System.out.println(worker2);
        System.out.println(worker1.hashCode());
        System.out.println(worker2.hashCode());
        System.out.println("John Mayer".hashCode());
    }
}