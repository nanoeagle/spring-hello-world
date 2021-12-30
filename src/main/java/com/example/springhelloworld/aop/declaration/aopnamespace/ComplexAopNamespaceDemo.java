package com.example.springhelloworld.aop.declaration.aopnamespace;

import com.example.springhelloworld.aop.advisorsandpointcuts.simplenamematching.GrammyGuitarist;
import com.example.springhelloworld.contextaware.Guitar;

import org.springframework.context.support.GenericXmlApplicationContext;

public class ComplexAopNamespaceDemo {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("appContextConfigs/app-context-aop-namespace-complex.xml");
        ctx.refresh();

        System.out.println("------guitarist1-------");
        doStuff(ctx.getBean("guitarist1", GrammyGuitarist.class));
        System.out.println("------guitarist2-------");
        doStuff(ctx.getBean("guitarist2", GrammyGuitarist.class));
        ctx.close();
    }

    private static void doStuff(GrammyGuitarist guitarist) {
        guitarist.sing();
        guitarist.talk();
        guitarist.sing(new Guitar());

        Guitar guitar = new Guitar();
        guitar.setBrand("Gibson");
        guitarist.sing(guitar);
    }
}