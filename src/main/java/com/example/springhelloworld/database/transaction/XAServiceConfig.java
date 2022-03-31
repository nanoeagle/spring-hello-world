package com.example.springhelloworld.database.transaction;

import java.util.Properties;

import javax.transaction.*;

import com.atomikos.icatch.config.*;
import com.atomikos.icatch.jta.*;

import org.slf4j.*;
import org.springframework.context.annotation.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.jta.JtaTransactionManager;

@ComponentScan(basePackages = "com.example.springhelloworld.database.transaction")
@EnableTransactionManagement
@Configuration
public class XAServiceConfig {
    private Logger LOGGER = LoggerFactory.getLogger(XAServiceConfig.class);

    @Bean
    public PlatformTransactionManager transactionManager() {
        JtaTransactionManager jtaTxM = new JtaTransactionManager();
        jtaTxM.setUserTransaction(atomikosUserTransaction());
        jtaTxM.setTransactionManager(atomikosTransactionManager());
        return jtaTxM;
    }
    
    @Bean
    @DependsOn("userTransactionService")
    public UserTransaction atomikosUserTransaction() {
        UserTransactionImp ut = new UserTransactionImp();
        try {
            ut.setTransactionTimeout(300);
        } catch (SystemException e) {
            LOGGER.error("Configuration exception.", e);
            return null;
        }
        return ut;
    }

    @Bean(initMethod = "init", destroyMethod = "close")
    @DependsOn("userTransactionService")
    public TransactionManager atomikosTransactionManager() {
        UserTransactionManager utm = new UserTransactionManager();
        utm.setStartupTransactionService(false);
        utm.setForceShutdown(true);
        return utm;
    }

    @Bean(initMethod = "init", destroyMethod = "shutdownForce")
    public UserTransactionService userTransactionService() {
        Properties props = new Properties();
        props.put("com.atomikos.icatch.service",
            "com.atomikos.icatch.standalone.UserTransactionServiceFactory");
        return new UserTransactionServiceImp(props);
    }
}