package com.example.helloworld.aop.declaration.aopnamespace;

import com.example.helloworld.aop.advisorsandpointcuts.simplenamematching.GrammyGuitarist;
import com.example.helloworld.contextaware.Guitar;

import org.springframework.context.support.GenericXmlApplicationContext;

public class AopNamespaceDemo {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("appContextConfigs/app-context-aop-namespace.xml");
        ctx.refresh();
        doStuff(ctx.getBean("guitarist", GrammyGuitarist.class));
        ctx.close();
    }

    private static void doStuff(GrammyGuitarist guitarist) {
        guitarist.sing();
        guitarist.sing(new Guitar());
        guitarist.talk();
    }
}