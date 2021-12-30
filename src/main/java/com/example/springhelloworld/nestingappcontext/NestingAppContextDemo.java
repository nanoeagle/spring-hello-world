package com.example.springhelloworld.nestingappcontext;

import org.springframework.context.support.GenericXmlApplicationContext;

public class NestingAppContextDemo {
    public static void main(String[] args) {

        GenericXmlApplicationContext parentContext = new GenericXmlApplicationContext();
        parentContext.load("appContextConfigs/parent-context.xml");
        parentContext.refresh();
        GenericXmlApplicationContext childContext = new GenericXmlApplicationContext();
        childContext.load("appContextConfigs/child-context.xml");
        childContext.setParent(parentContext);
        childContext.refresh();

        Song song1 = childContext.getBean("song1", Song.class);
        Song song2 = childContext.getBean("song2", Song.class);
        Song song3 = childContext.getBean("song3", Song.class);

        childContext.close();
        parentContext.close();

        System.out.println("from parent ctx: " + song1.getTitle());
        System.out.println("from child ctx: " + song2.getTitle());
        System.out.println("from parent ctx: " + song3.getTitle()); 
    }
}