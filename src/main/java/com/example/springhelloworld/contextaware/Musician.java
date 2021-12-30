package com.example.springhelloworld.contextaware;

import org.springframework.context.*;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

@Component("johnMayer")
@DependsOn("gopher")
public class Musician implements ApplicationContextAware {
    private Guitar guitar;
    private ApplicationContext context;
    
    @Override
    public void setApplicationContext(ApplicationContext context) {
        this.context = context;
    }

    public void playInstrument() {
        guitar = context.getBean("gopher", Guitar.class);
        guitar.play();
    }
}