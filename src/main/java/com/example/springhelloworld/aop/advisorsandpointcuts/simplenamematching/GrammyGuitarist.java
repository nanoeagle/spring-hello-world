package com.example.springhelloworld.aop.advisorsandpointcuts.simplenamematching;

import com.example.springhelloworld.aop.advisorsandpointcuts.annotationpointcut.AdviceRequired;
import com.example.springhelloworld.contextaware.Guitar;

import org.springframework.stereotype.Component;

@Component("guitarist")
public class GrammyGuitarist {
    public void sing() {
        System.out.println(
            "sing: Gravity is working against me\n" +
            "And gravity wants to bring me down");
    }

    @AdviceRequired
    public void sing(Guitar guitar) {
        System.out.println("play: ");
        guitar.play();
    }

    public void rest(){
        System.out.println("zzz");
    }

    public void talk(){
        System.out.println("talk");
    }
}