package com.example.helloworld.aop.springaoparchitecture.beforeadvice;

public class UserInfo {
    private String userName;
    private String password;
    
    public UserInfo(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
    
    public String getPassword() {
        return password;
    }
    
    public String getUserName() {
        return userName;
    }
}