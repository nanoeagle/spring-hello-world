package com.example.springhelloworld.autowiring;

import org.springframework.context.annotation.*;

// @ImportResource(locations = "appContextConfigs/app-context-autowiring.xml")
// @ComponentScan(basePackages = "com.example.springhelloworld")
// @Configuration
public class AutowiringConfig {
    @Bean
    public Foo fooImplOne() {
    	return new FooImplOne();
    }
    @Bean
    public Foo fooImplTwo() {
    	return new FooImplTwo();
    }
    @Bean
    public Bar bar() {
    	return new Bar();
    }
    @Bean
    public Target target() {
    	return new Target();
    }  
}