package com.example.helloworld.lookupmethodinjection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.util.StopWatch;

public class LookupMethodInjectionDemo {
    public static void main(String[] args) {
        ApplicationContext context = 
            new AnnotationConfigApplicationContext(LookupMethodInjectionConfig.class);
        
        StandardLookup standardLookup = 
            context.getBean("standardLookup", StandardLookup.class);
        displayLookupInfo("standardLookup", standardLookup);
        
        AbstractLookup abstractLookup = 
            context.getBean("abstractLookup", AbstractLookup.class);
        displayLookupInfo("abstractLookup", abstractLookup);
        
        StandardLookup standardLookup2 = 
            context.getBean("standardLookup", StandardLookup.class);
        System.out.println(standardLookup.getMyVocalist() == standardLookup2.getMyVocalist());
    }

    private static void displayLookupInfo(String beanName, DemoBean bean) {
        Vocalist vocalist1 = bean.getMyVocalist();
        Vocalist vocalist2 = bean.getMyVocalist();
        System.out.println(
            beanName + ": vocalist Instances the Same? " 
            + (vocalist1 == vocalist2)
        );

        StopWatch stopWatch = new StopWatch();
        stopWatch.start("lookupDemo");
        
        for (int i = 0; i < 100000; i++) {
            Vocalist vocalist = bean.getMyVocalist();
            vocalist.sing();
        }

        stopWatch.stop();
        System.out.println(
            "100000 gets took " 
            + stopWatch.getTotalTimeMillis() + " ms"
        );
    }
}