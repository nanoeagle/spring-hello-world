package com.example.springhelloworld.beanfactory;

import java.security.MessageDigest;

public class MessageDigester {
    private MessageDigest mesDigest1;
    private MessageDigest mesDigest2;

    public void setMesDigest1(MessageDigest mesDigest1) {
        this.mesDigest1 = mesDigest1;
    }

    public void setMesDigest2(MessageDigest mesDigest2) {
        this.mesDigest2 = mesDigest2;
    }

    public void digest(String message) {
        System.out.println("Original message: " + message);
        digest(message, mesDigest1);
        digest(message, mesDigest2);
    }

    private void digest(String message, MessageDigest mesDigest) {
        System.out.print(
            "Encoded message using alogrithm " + 
            mesDigest.getAlgorithm() + ": "
        );
        mesDigest.reset();
        byte[] outBytes = mesDigest.digest(message.getBytes());
        for (byte b : outBytes) {
            System.out.print((char) b);
        }
        System.out.println();
    }
}