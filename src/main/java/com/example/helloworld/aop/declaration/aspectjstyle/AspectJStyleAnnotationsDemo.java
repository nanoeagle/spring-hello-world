package com.example.helloworld.aop.declaration.aspectjstyle;

import com.example.helloworld.aop.advisorsandpointcuts.simplenamematching.GrammyGuitarist;
import com.example.helloworld.contextaware.Guitar;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AspectJStyleAnnotationsDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx =
            new AnnotationConfigApplicationContext(
                AspectJStyleAnnotationsConfig.class);
        doStuff(ctx.getBean("guitarist", GrammyGuitarist.class));
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