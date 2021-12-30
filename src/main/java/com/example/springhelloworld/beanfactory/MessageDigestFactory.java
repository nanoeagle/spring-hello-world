package com.example.springhelloworld.beanfactory;

import java.security.*;

public class MessageDigestFactory {
    
    private String algorithm = "MD5";

    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }

    public MessageDigest createInstance() throws NoSuchAlgorithmException {
        return MessageDigest.getInstance(algorithm);
    }
}