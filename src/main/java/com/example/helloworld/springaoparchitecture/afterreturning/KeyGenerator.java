package com.example.helloworld.springaoparchitecture.afterreturning;

import java.util.Random;

public class KeyGenerator {
    protected static final long WEAK_KEY = 0xFFFFFFF0000000L;
    protected static final long STRONG_KEY = 0xACDF03F590AE56L;

    private Random random;
    
    public KeyGenerator() {
        random = new Random();
    }

    public long getKey() {
        int randomInt = random.nextInt(3);
        if (randomInt == 1) {
            return WEAK_KEY;
        }
        return STRONG_KEY;
    }
}