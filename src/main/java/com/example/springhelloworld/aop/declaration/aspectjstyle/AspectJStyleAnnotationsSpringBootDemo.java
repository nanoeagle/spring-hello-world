package com.example.springhelloworld.aop.declaration.aspectjstyle;

import com.example.springhelloworld.aop.advisorsandpointcuts.simplenamematching.GrammyGuitarist;
import com.example.springhelloworld.contextaware.Guitar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class AspectJStyleAnnotationsSpringBootDemo {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = 
            SpringApplication.run(
                AspectJStyleAnnotationsSpringBootDemo.class, args);
        assert context != null;
        
        doStuff(context.getBean("guitarist", GrammyGuitarist.class));
        context.close();
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