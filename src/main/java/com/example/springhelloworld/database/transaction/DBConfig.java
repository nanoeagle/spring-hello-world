package com.example.springhelloworld.database.transaction;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.slf4j.*;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.datasource.embedded.*;
import org.springframework.orm.jpa.*;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.context.annotation.Configuration;

// @ImportResource(locations = "appContextConfigs/app-context-database-transaction.xml")
@Configuration
public class DBConfig {
    private static final Logger LOGGER = LoggerFactory.getLogger(DBConfig.class);

    @Bean
    public EntityManagerFactory entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean emfBean = 
            new LocalContainerEntityManagerFactoryBean();
        emfBean.setPackagesToScan("com.example.springhelloworld.database.transaction");
        emfBean.setDataSource(dataSource());
        emfBean.setJpaVendorAdapter(jpaVendorAdapter());
        emfBean.setJpaProperties(hibernateProperties());
        emfBean.afterPropertiesSet();
        return emfBean.getNativeEntityManagerFactory();
    }

    @Bean
    public DataSource dataSource() {
        try {
            EmbeddedDatabaseBuilder dbBuilder = new EmbeddedDatabaseBuilder();
            return dbBuilder.setType(EmbeddedDatabaseType.H2)
                .addScripts("databases/H2/springjdbc/schema.sql", "databases/H2/springjdbc/data.sql")
                .build();
        } catch (Exception e) {
            LOGGER.error("Embedded dataSource cannot be created!", e);
            return null;
        }
    }

    private JpaVendorAdapter jpaVendorAdapter() {
        return new HibernateJpaVendorAdapter();
    }

    private Properties hibernateProperties() {
        Properties props = new Properties();
        props.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        props.put("hibernate.format_sql", true);
        props.put("hibernate.show_sql", true);
        props.put("hibernate.max_fetch_depth", 3);
        props.put("hibernate.jdbc.fetch_size", 50);
        props.put("hibernate.jdbc.batch_size", 10);
        return props;
    }
}