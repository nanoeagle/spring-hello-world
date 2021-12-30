package com.example.springhelloworld.methodreplacement;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.util.StopWatch;

public class MethodReplacementDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(MethodReplacementConfig.class);
    
        ReplacementTarget replacementTarget = 
            context.getBean("replacementTarget", ReplacementTarget.class);
        displayInfo(replacementTarget);

        ReplacementTarget standardReplacementTarget = 
            context.getBean("standardReplacementTarget", ReplacementTarget.class);
        displayInfo(standardReplacementTarget);

        context.close();
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