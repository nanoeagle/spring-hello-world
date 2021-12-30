package com.example.springhelloworld.aop.declaration.proxyfactorybean;

import com.example.springhelloworld.aop.advisorsandpointcuts.simplenamematching.GrammyGuitarist;
import com.example.springhelloworld.contextaware.Guitar;

import org.springframework.context.support.GenericXmlApplicationContext;

public class ProxyFactoryBeanDemo {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("appContextConfigs/app-context-aop-proxy-factorybean.xml");
        ctx.refresh();

        System.out.println("Guitarist One:");
        doStuff(ctx.getBean("proxyGuitaristOne", GrammyGuitarist.class));
        System.out.println("\nGuitarist Two:");
        doStuff(ctx.getBean("proxyGuitaristTwo", GrammyGuitarist.class));

        ctx.close();
    }

    private static void doStuff(GrammyGuitarist guitarist) {
        guitarist.sing();
        guitarist.sing(new Guitar());
        guitarist.talk();
    }
}