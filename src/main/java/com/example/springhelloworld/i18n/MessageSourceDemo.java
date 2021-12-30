package com.example.springhelloworld.i18n;

import java.util.Locale;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MessageSourceDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(MessageSourceConfig.class);

        Locale en = Locale.ENGLISH;
        Locale de = Locale.GERMAN;
        Locale vie = new Locale("vie", "VN");
        
        System.out.println("\nEnglish:");    
        System.out.println("\t" + context.getMessage("greeting", null, en));
        System.out.println("\t" + context.getMessage("comment", null, en));
        System.out.println("\t" + context.getMessage("comment", null, en));
        System.out.println("\t" + context.getMessage(
            "myName", new Object[] {"Minh", "Le"}, en));

        System.out.println("\nGerman:");      
        System.out.println("\t" + context.getMessage("greeting", null, de));
        System.out.println("\t" + context.getMessage("comment", null, de));
        System.out.println("\t" + context.getMessage(
            "myName", new Object[] {"Minh", "Le"}, de));
        
        System.out.println("\nVietnamese:");      
        System.out.println("\t" + context.getMessage("greeting", null, vie));
        System.out.println("\t" + context.getMessage("comment", null, vie));
        System.out.println("\t" + context.getMessage(
            "myName", new Object[] {"Lê", "Minh"}, vie));
        // getMessage with 4 args.
        System.out.println("\t" + context.getMessage(
            "status", null, "Tôi khỏe.", vie));
        // getMessage with MessageSourceResolvable.
        System.out.println("\t" + context.getMessage(
            new MarriageMessageKey(), vie));
        
        context.close();
    }
}