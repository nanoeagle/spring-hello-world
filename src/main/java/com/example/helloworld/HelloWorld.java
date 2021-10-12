package com.example.helloworld;

import com.example.helloworld.beaninstantiationmode.Worker;
import com.example.helloworld.contextaware.Musician;
// import com.example.helloworld.collectioninjection.CollectionInjection;
import com.example.helloworld.lookupmethodinjection.*;
import com.example.helloworld.methodreplacement.ReplacementTarget;
import com.example.helloworld.nestingappcontext.Song;
import com.example.helloworld.paraminjection.Singer;
import com.example.helloworld.renderer.MessageRenderer;
import com.example.helloworld.simplevalueinjection.SimpleValueInjection;
import com.example.helloworld.springexpressionlanguage.SimpleValueInjectionSpEL;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.util.StopWatch;

public class HelloWorld {
    public static void main(String[] args) {
        ApplicationContext context = 
            new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);
        MessageRenderer renderer = context.getBean("renderer", MessageRenderer.class);
        renderer.render();
        Singer singer = context.getBean("singer", Singer.class);
        singer.sing();
        SimpleValueInjection svInjection = context.getBean("valueInjection", SimpleValueInjection.class);
        System.out.println(svInjection);  
        SimpleValueInjectionSpEL svInjectionSpEL = context.getBean("valueInjectionSpEL", SimpleValueInjectionSpEL.class);
        System.out.println(svInjectionSpEL);  

        GenericXmlApplicationContext parentContext = new GenericXmlApplicationContext();
        parentContext.load("parent-context.xml");
        parentContext.refresh();
        GenericXmlApplicationContext childContext = new GenericXmlApplicationContext();
        childContext.load("child-context.xml");
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

        // CollectionInjection collectionInjection = context.getBean("injectCollection", CollectionInjection.class);
        // collectionInjection.displayInfo();

        StandardLookup standardLookup = 
            context.getBean("standardLookup", StandardLookup.class);
        displayLookupInfo("standardLookup", standardLookup);
        
        AbstractLookup abstractLookup = 
            context.getBean("abstractLookup", AbstractLookup.class);
        displayLookupInfo("abstractLookup", abstractLookup);
        
        StandardLookup standardLookup2 = 
            context.getBean("standardLookup", StandardLookup.class);
        System.out.println(standardLookup.getMyVocalist() == standardLookup2.getMyVocalist());

        ReplacementTarget replacementTarget = 
            context.getBean("replacementTarget", ReplacementTarget.class);
        displayInfo(replacementTarget);

        ReplacementTarget standardReplacementTarget = 
            context.getBean("standardReplacementTarget", ReplacementTarget.class);
        displayInfo(standardReplacementTarget);

        Worker worker1 = context.getBean("nonSingleton", Worker.class);
        Worker worker2 = context.getBean("nonSingleton", Worker.class);
        compareWorkers(worker1, worker2);

        Musician musician = context.getBean("johnMayer", Musician.class);
        musician.playInstrument();
    }

    public static void displayLookupInfo(String beanName, DemoBean bean) {
        Vocalist vocalist1 = bean.getMyVocalist();
        Vocalist vocalist2 = bean.getMyVocalist();
        System.out.println(
            beanName + ": vocalist Instances the Same? " 
            + (vocalist1 == vocalist2)
        );

        StopWatch stopWatch = new StopWatch();
        stopWatch.start("lookupDemo");
        
        for (int i = 0; i < 100000; i++) {
            Vocalist vocalist = bean.getMyVocalist();
            vocalist.sing();
        }

        stopWatch.stop();

        System.out.println(
            "100000 gets took " 
            + stopWatch.getTotalTimeMillis() + " ms"
        );
    }

    private static void displayInfo(ReplacementTarget target) {
        System.out.println(target.formatMessage("Thanks for playing, try again!"));
        
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("replacementTest");
        
        for (int x = 0; x < 1000000; x++) {
            target.formatMessage("No filter in my head");
        }

        stopWatch.stop();
        System.out.println("1000000 invocations took: " 
            + stopWatch.getTotalTimeMillis() + " ms");
    }

    private static void compareWorkers(Worker worker1, Worker worker2) {
        System.out.println("Identity Equal? " + (worker1 == worker2));
        System.out.println("Value Equal? " + worker1.equals(worker2));
        System.out.println(worker1);
        System.out.println(worker2);
        System.out.println(worker1.hashCode());
        System.out.println(worker2.hashCode());
        System.out.println("John Mayer".hashCode());
    }
}