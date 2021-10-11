package com.example.helloworld.lookupmethodinjection;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("vocalistBean")
@Scope("prototype")
public class Vocalist {
    public void sing() {
    //commented to avoid polluting the output.
    //System.out.println(lyric);
    }
}