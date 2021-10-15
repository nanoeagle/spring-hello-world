package com.example.helloworld.methodreplacement;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.util.StopWatch;

public class MethodReplacementDemo {
    public static void main(String[] args) {
        ApplicationContext context = 
            new AnnotationConfigApplicationContext(MethodReplacementConfig.class);
    
        ReplacementTarget replacementTarget = 
            context.getBean("replacementTarget", ReplacementTarget.class);
        displayInfo(replacementTarget);

        ReplacementTarget standardReplacementTarget = 
            context.getBean("standardReplacementTarget", ReplacementTarget.class);
        displayInfo(standardReplacementTarget);  
    }

    private static void displayInfo(ReplacementTarget target) {
        System.out.println(target.formatMessage("Thanks for playing, try again!"));
        
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("replacementTest");
        
        for (int x = 0; x < 1000000; x++) {
            target.formatMessage("No filter in my head");
        }

        stopWatch.stop();
        System.out.println("1000000 invocations took: " 
            + stopWatch.getTotalTimeMillis() + " ms");
    }
}