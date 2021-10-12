package com.example.helloworld.contextaware;

import org.springframework.stereotype.Component;

@Component("gopher")
public class Guitar {
    public void play() {
        System.out.println("Cm Eb Fm Ab Bb");
    }
}