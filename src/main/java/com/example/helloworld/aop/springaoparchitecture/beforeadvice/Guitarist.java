package com.example.helloworld.aop.springaoparchitecture.beforeadvice;

public class Guitarist {
    public void sing(String songName){
        System.out.println(
            "I'm singing the song " + songName +
            "... " + "You're gonna live forever in me.");
    }
}