package com.example.helloworld.lookupmethodinjection;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

@Component("abstractLookup")
public abstract class AbstractLookup implements DemoBean {
    @Override
    @Lookup("vocalistBean")
    public abstract Vocalist getMyVocalist();

    @Override
    public void doSomething() {
        getMyVocalist().sing();
    }
}