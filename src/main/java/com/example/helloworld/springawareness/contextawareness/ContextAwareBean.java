package com.example.helloworld.springawareness.contextawareness;

import org.springframework.beans.factory.*;
import org.springframework.context.*;
import org.springframework.context.annotation.*;

public class ContextAwareBean implements DisposableBean, ApplicationContextAware {
    
    @Override
    public void destroy() throws Exception {
        System.out.println("ContextAwareBean destroy().");
    }

    @Override
    public void setApplicationContext(ApplicationContext ctx) {
        if (ctx instanceof AnnotationConfigApplicationContext) {
            ((AnnotationConfigApplicationContext) ctx).registerShutdownHook();
        }
    }
}