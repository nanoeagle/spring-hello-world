package com.example.helloworld.beaninheritance;

import org.springframework.context.annotation.*;

@ImportResource(locations = "app-context-bean-inheritance.xml")
// @ComponentScan(basePackages = "com.example.helloworld")
@Configuration
public class BeanInheritanceConfig {}