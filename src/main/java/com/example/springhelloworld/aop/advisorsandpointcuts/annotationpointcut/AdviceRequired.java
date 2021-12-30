package com.example.springhelloworld.aop.advisorsandpointcuts.annotationpointcut;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface AdviceRequired {}