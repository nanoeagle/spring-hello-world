package com.example.helloworld.aop.declaration.proxyfactorybean;

import com.example.helloworld.aop.advisorsandpointcuts.simplenamematching.GrammyGuitarist;
import com.example.helloworld.contextaware.Guitar;

import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.context.support.GenericXmlApplicationContext;

public class ProxyFactoryBeanDemo {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("appContextConfigs/app-context-aop-proxy-factorybean.xml");
        ctx.refresh();

        GrammyGuitarist proxyGuitaristOne = 
            ctx.getBean("proxyGuitaristOne", GrammyGuitarist.class);
        GrammyGuitarist proxyGuitaristTwo = 
            ctx.getBean("proxyGuitaristTwo", GrammyGuitarist.class);

        System.out.println("Guitarist One:");
        doStuff(proxyGuitaristOne);
        System.out.println("\nGuitarist Two:");
        doStuff(proxyGuitaristTwo);

        ctx.close();
    }

    private static void doStuff(GrammyGuitarist guitarist) {
        guitarist.sing();
        guitarist.sing(new Guitar());
        guitarist.talk();
    }
}