package com.example.helloworld.aop.springaoparchitecture.throwsadvice;

public class ErrorBean {
    public void errorProneMethod() throws Exception {
        throw new Exception("Generic Exception");
    }

    public void otherErrorProneMethod() throws IllegalArgumentException {
        throw new IllegalArgumentException("IllegalArgument Exception");
    }

    public void notErrorProneMethod() {
        System.out.println("This is not an error.");
    }
}