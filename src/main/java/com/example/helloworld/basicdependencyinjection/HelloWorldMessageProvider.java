package com.example.helloworld.basicdependencyinjection;

import org.springframework.stereotype.Component;

@Component("provider2")
public class HelloWorldMessageProvider implements MessageProvider {
    @Override
    public String getMessage() {
        return "Hello World";
    }
}