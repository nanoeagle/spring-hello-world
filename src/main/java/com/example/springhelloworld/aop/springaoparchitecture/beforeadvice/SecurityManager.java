package com.example.springhelloworld.aop.springaoparchitecture.beforeadvice;

public class SecurityManager {
    private static ThreadLocal<UserInfo> threadLocal;
       
    static {
        threadLocal = new ThreadLocal<>();
    }

    public void login(String userName, String password) {
        threadLocal.set(new UserInfo(userName, password));
    }

    public UserInfo getLoggedInUser() {
        return threadLocal.get();
    }

    public void logout() {
        threadLocal.set(null);
    }
}