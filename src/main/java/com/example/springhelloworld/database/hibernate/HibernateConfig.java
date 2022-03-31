package com.example.springhelloworld.database.hibernate;

// import java.io.IOException;
// // import java.sql.Driver;
// import java.util.Properties;

// import javax.sql.DataSource;

// import org.hibernate.SessionFactory;
// import org.slf4j.*;
// import org.springframework.context.annotation.*;
// // import org.springframework.jdbc.datasource.SimpleDriverDataSource;
// import org.springframework.jdbc.datasource.embedded.*;
// import org.springframework.orm.hibernate5.*;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.transaction.PlatformTransactionManager;
// import org.springframework.transaction.annotation.EnableTransactionManagement;

// // @ImportResource(locations = "appContextConfigs/app-context-database-hibernate.xml")
// @ComponentScan(basePackages = "com.example.springhelloworld.database.hibernate")
// @EnableTransactionManagement
// @Configuration
public class HibernateConfig {
//     private static final Logger LOGGER = LoggerFactory.getLogger(HibernateConfig.class);

//     @Bean
//     public PlatformTransactionManager transactionManager() throws IOException {
//         return new HibernateTransactionManager(sessionFactory());
//     }

//     @Bean 
//     public SessionFactory sessionFactory() throws IOException {
//         LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
//         sessionFactoryBean.setPackagesToScan("com.example.springhelloworld.database.hibernate");
//         sessionFactoryBean.setDataSource(dataSource());
//         sessionFactoryBean.setHibernateProperties(hibernateProperties());
//         sessionFactoryBean.afterPropertiesSet();
//         return sessionFactoryBean.getObject();
//     }

//     @Bean
//     public DataSource dataSource() {
//         try {
//             EmbeddedDatabaseBuilder dbBuilder = new EmbeddedDatabaseBuilder();
//             return dbBuilder.setType(EmbeddedDatabaseType.H2)
//                 .addScripts("databases/H2/hibernate/schema.sql", "databases/H2/hibernate/data.sql")
//                 .build();
//         } catch (Exception e) {
//             LOGGER.error("Embedded dataSource cannot be created!", e);
//             return null;
//         }
//     }

//     // For MySql.
//     /* @Bean
//     public DataSource dataSource() {
//         try {
//             SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
//             Class<? extends Driver> driverClass = 
//                 Class.forName("com.mysql.cj.jdbc.Driver").asSubclass(Driver.class);
//             dataSource.setDriverClass(driverClass);
//             dataSource.setUrl("jdbc:mysql://localhost:3306/musicdb?useSSL=true");
//             dataSource.setUsername("root");
//             dataSource.setPassword("mysql");
//             return dataSource;
//         } catch (Exception e) {
//             LOGGER.error("The dataSource cannot be created!", e);
//             return null;
//         }
//     } */

//     private Properties hibernateProperties() {
//         Properties props = new Properties();
//         props.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
//         // props.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
//         props.put("hibernate.format_sql", true);
//         props.put("hibernate.use_sql_comments", true);
//         props.put("hibernate.show_sql", true);
//         props.put("hibernate.max_fetch_depth", 3);
//         props.put("hibernate.jdbc.fetch_size", 50);
//         props.put("hibernate.jdbc.batch_size", 10);
//         return props;
//     }
}