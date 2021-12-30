package com.example.springhelloworld.paraminjection;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Inspiration {
    private String lyric =
        "I can keep the door cracked open, to let light through";
    
    public Inspiration(
        @Value("For all my running, I can understand") 
        String lyric
    ) { this.lyric = lyric; }

    public String getLyric() { return lyric; }
}