package com.example.springhelloworld.lookupmethodinjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("standardLookup")
public class StandardLookup implements DemoBean {
    private Vocalist vocalist;
    
    @Autowired
    public void setVocalist(Vocalist vocalist) {
        this.vocalist = vocalist;
    }

    @Override
    public Vocalist getMyVocalist() {
        return vocalist;
    }

    @Override
    public void doSomething() {
        vocalist.sing();
    }
}