package com.example.helloworld.contextaware;

import org.springframework.beans.BeansException;
import org.springframework.context.*;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

@Component("johnMayer")
@DependsOn("gopher")
public class Musician implements ApplicationContextAware {
    private Guitar guitar;
    private ApplicationContext context;
    
    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        this.context = context;
    }

    public void playInstrument() {
        guitar = context.getBean("gopher", Guitar.class);
        guitar.play();
    }
}