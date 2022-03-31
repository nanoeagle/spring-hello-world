package com.example.springhelloworld.database.jpa;

// import java.io.IOException;
// // import java.sql.Driver;
// import java.util.Properties;

// import javax.persistence.EntityManagerFactory;
// import javax.sql.DataSource;

// import org.slf4j.*;
// import org.springframework.context.annotation.*;
// // import org.springframework.jdbc.datasource.SimpleDriverDataSource;
// import org.springframework.jdbc.datasource.embedded.*;
// import org.springframework.orm.jpa.*;
// import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.data.jpa.repository.config.*;
// import org.springframework.transaction.PlatformTransactionManager;
// import org.springframework.transaction.annotation.EnableTransactionManagement;

// @ImportResource(locations = "appContextConfigs/app-context-database-jpa.xml")
// @ComponentScan(basePackages = "com.example.springhelloworld.database.jpa")
// @EnableTransactionManagement
// @EnableJpaRepositories
// @EnableJpaAuditing(auditorAwareRef = "auditorAwareBean")
// @Configuration
public class JpaConfig {
    // private static final Logger LOGGER = LoggerFactory.getLogger(JpaConfig.class);

    // @Bean
    // public PlatformTransactionManager transactionManager() throws IOException {
    //     return new JpaTransactionManager(entityManagerFactory());
    // }

    // @Bean
    // public EntityManagerFactory entityManagerFactory() {
    //     LocalContainerEntityManagerFactoryBean emfBean = 
    //         new LocalContainerEntityManagerFactoryBean();
    //     emfBean.setPackagesToScan("com.example.springhelloworld.database.jpa");
    //     emfBean.setDataSource(dataSource());
    //     emfBean.setJpaVendorAdapter(jpaVendorAdapter());
    //     emfBean.setJpaProperties(hibernateProperties());
    //     emfBean.afterPropertiesSet();
    //     return emfBean.getNativeEntityManagerFactory();
    // }

    // @Bean
    // public DataSource dataSource() {
    //     try {
    //         EmbeddedDatabaseBuilder dbBuilder = new EmbeddedDatabaseBuilder();
    //         return dbBuilder.setType(EmbeddedDatabaseType.H2)
    //             .addScripts("databases/H2/hibernate/schema.sql", "databases/H2/hibernate/data.sql")
    //             .build();
    //     } catch (Exception e) {
    //         LOGGER.error("Embedded dataSource cannot be created!", e);
    //         return null;
    //     }
    // }

    // // For MySql.
    // /* @Bean
    // public DataSource dataSource() {
    //     try {
    //         SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
    //         Class<? extends Driver> driverClass = 
    //             Class.forName("com.mysql.cj.jdbc.Driver").asSubclass(Driver.class);
    //         dataSource.setDriverClass(driverClass);
    //         dataSource.setUrl("jdbc:mysql://localhost:3306/musicdb?useSSL=true");
    //         dataSource.setUsername("root");
    //         dataSource.setPassword("mysql");
    //         return dataSource;
    //     } catch (Exception e) {
    //         LOGGER.error("The dataSource cannot be created!", e);
    //         return null;
    //     }
    // } */

    // private JpaVendorAdapter jpaVendorAdapter() {
    //     return new HibernateJpaVendorAdapter();
    // }

    // private Properties hibernateProperties() {
    //     Properties props = new Properties();
    //     props.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
    //     // props.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
    //     props.put("hibernate.format_sql", true);
    //     props.put("hibernate.use_sql_comments", true);
    //     props.put("hibernate.show_sql", true);
    //     props.put("hibernate.max_fetch_depth", 3);
    //     props.put("hibernate.jdbc.fetch_size", 50);
    //     props.put("hibernate.jdbc.batch_size", 10);
    //     props.put("org.hibernate.envers.audit_table_suffix", "_H"); // H is history.
    //     props.put("org.hibernate.envers.revision_field_name", "AUDIT_REVISION");
    //     props.put("org.hibernate.envers.revision_type_field_name", "ACTION_TYPE");
    //     props.put("org.hibernate.envers.audit_strategy",
    //         "org.hibernate.envers.strategy.ValidityAuditStrategy");
    //     props.put(
    //         "org.hibernate.envers.audit_strategy_validity_end_rev_field_name",
    //         "AUDIT_REVISION_END");
    //     props.put(
    //         "org.hibernate.envers.audit_strategy_validity_store_revend_timestamp",
    //         "True");
    //     props.put(
    //         "org.hibernate.envers.audit_strategy_validity_revend_timestamp_field_name",
    //         "AUDIT_REVISION_END_TS");
    //     return props;
    // }
}