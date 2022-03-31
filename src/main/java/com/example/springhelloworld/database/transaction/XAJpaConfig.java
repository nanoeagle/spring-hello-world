package com.example.springhelloworld.database.transaction;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import com.atomikos.jdbc.AtomikosDataSourceBean;

import org.slf4j.*;
import org.springframework.context.annotation.*;
import org.springframework.orm.jpa.*;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
public class XAJpaConfig {
    private static Logger LOGGER = LoggerFactory.getLogger(XAJpaConfig.class);
    
    @Bean
    public EntityManagerFactory emfA() {
        return entityManagerFactory(dataSourceA(), "emfA");
    }

    @Bean
    public EntityManagerFactory emfB() {
        return entityManagerFactory(dataSourceB(), "emfB");
    }

    private EntityManagerFactory entityManagerFactory(DataSource ds, String name) {
        LocalContainerEntityManagerFactoryBean factoryBean =
            new LocalContainerEntityManagerFactoryBean();
        factoryBean.setPackagesToScan("com.example.springhelloworld.database.transaction");
        factoryBean.setDataSource(ds);
        factoryBean.setJpaVendorAdapter(jpaVendorAdapter());
        factoryBean.setJpaProperties(hibernateProperties());
        factoryBean.setPersistenceUnitName(name);
        factoryBean.afterPropertiesSet();
        return factoryBean.getObject();
    }

    private JpaVendorAdapter jpaVendorAdapter() {
        return new HibernateJpaVendorAdapter();
    }    

    private Properties hibernateProperties() {
        Properties hibernateProp = new Properties();
        hibernateProp.put("hibernate.transaction.coordinator_class", "jta");
        hibernateProp.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
        hibernateProp.put("hibernate.show_sql", true);
        hibernateProp.put("hibernate.max_fetch_depth", 3);
        hibernateProp.put("hibernate.jdbc.batch_size", 10);
        hibernateProp.put("hibernate.jdbc.fetch_size", 50);
        return hibernateProp;
    }

    @Bean(initMethod = "init", destroyMethod = "close")
    public DataSource dataSourceA() {
        Properties xaProp = xaProperties("musicdb_a", "nanoeagleA", "admin");
        return dataSource("XADBMSA", xaProp);
    }

    @Bean(initMethod = "init", destroyMethod = "close")
    public DataSource dataSourceB() {
        Properties xaProp = xaProperties("musicdb_b", "nanoeagleB", "admin");
        return dataSource("XADBMSB", xaProp);
    }
    
    private Properties xaProperties(String databaseName, String user, String pwd) {
        Properties xaProp = new Properties();
        xaProp.put("databaseName", databaseName);
        xaProp.put("user", user);
        xaProp.put("password", pwd);
        return xaProp;
    }

    private AtomikosDataSourceBean dataSource(String resourceName, Properties xaProperties) {
        try {
            AtomikosDataSourceBean dataSource = new AtomikosDataSourceBean();
            dataSource.setUniqueResourceName(resourceName);
            dataSource.setXaDataSourceClassName("com.mysql.cj.jdbc.MysqlXADataSource");
            dataSource.setXaProperties(xaProperties);
            dataSource.setPoolSize(1);
            return dataSource;
        } catch (Exception e) {
            LOGGER.error("DataSource bean cannot be created!", e);
            return null;
        }
    }
}