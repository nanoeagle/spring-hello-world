package com.example.springhelloworld.database.transaction;

import java.io.IOException;

import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.orm.jpa.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

// @ImportResource(locations = "appContextConfigs/app-context-database-transaction.xml")
@ComponentScan(basePackages = "com.example.springhelloworld.database.transaction")
@EnableTransactionManagement
@Configuration
public class ServiceConfig {
    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Bean
    public PlatformTransactionManager transactionManager() throws IOException {
        return new JpaTransactionManager(entityManagerFactory);
    }
}