package com.example.springhelloworld.database.springjdbc.datasource;

// import java.sql.Driver;

// import javax.sql.DataSource;

// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.context.annotation.*;
// import org.springframework.jdbc.datasource.SimpleDriverDataSource;

// @ImportResource("appContextConfigs/app-context-database-spring-jdbc.xml")
// @ImportResource("appContextConfigs/app-context-database-spring-jdbc-2.xml")
// @PropertySource("supportFiles/springJDBC.properties")
// @PropertySource("supportFiles/springJDBC_2.properties")
// @Configuration
public class SpringJdbcConfig {
	// // @Value("${jdbc.driverClassName}")
	// @Value("${driverClassName}")
	// private String driverClassName;
	// // @Value("${jdbc.url}")
	// @Value("${url}")
	// private String url;
	// // @Value("${jdbc.username}")
	// @Value("${mySqlUsername}")
	// private String username;
	// // @Value("${jdbc.password}")
	// @Value("${password}")
	// private String password;
	
	// @Lazy
	// @Bean
	// public DataSource dataSource() {
	// 	try {
	// 		SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
	// 		Class<? extends Driver> driverClass = 
	// 			Class.forName(driverClassName).asSubclass(Driver.class);
	// 		dataSource.setDriverClass(driverClass);
	// 		dataSource.setUrl(url);
	// 		dataSource.setUsername(username);
	// 		dataSource.setPassword(password);
	// 		return dataSource;
	// 	} catch (Exception e) {
	// 		e.printStackTrace();
	// 		return null;
	// 	}
	// }
}