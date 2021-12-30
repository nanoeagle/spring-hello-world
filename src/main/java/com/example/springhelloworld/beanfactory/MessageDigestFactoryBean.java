package com.example.springhelloworld.beanfactory;

import javax.annotation.PostConstruct;

import java.security.*;

import org.springframework.beans.factory.FactoryBean;

public class MessageDigestFactoryBean implements FactoryBean<MessageDigest> {
    
    private String algorithm = "MD5";
    private MessageDigest messageDigest;

    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }

    @PostConstruct
    public void initMessageDigest() throws NoSuchAlgorithmException {
        messageDigest = MessageDigest.getInstance(algorithm);
    }

    @Override
    public MessageDigest getObject() throws Exception {
        return messageDigest;
    }

    @Override
    public Class<?> getObjectType() {
        return MessageDigest.class;
    }
}