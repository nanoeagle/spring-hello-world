package com.example.springhelloworld.database.springjdbc.embedded;

// import javax.sql.DataSource;

// import com.example.springhelloworld.database.plainjdbc.SingerDao;

// import org.slf4j.*;
// import org.springframework.context.annotation.*;
// import org.springframework.jdbc.datasource.embedded.*;

// @ImportResource("appContextConfigs/app-context-database-spring-jdbc-embedded.xml")
// @Configuration
public class EmbeddedDatabaseConfig {
	// private static final Logger LOGGER =
	// 	LoggerFactory.getLogger(EmbeddedDatabaseConfig.class);
	
	// @Bean
	// public SingerDao singerDao() {
	// 	SpringJdbcSingerDao dao = new SpringJdbcSingerDao();
	// 	dao.setDataSource(dataSource());
	// 	return dao;
	// }

	// @Bean
	// public DataSource dataSource() {
	// 	try {
	// 		EmbeddedDatabaseBuilder dbBuilder = new EmbeddedDatabaseBuilder();
	// 		return dbBuilder.setType(EmbeddedDatabaseType.H2)
	// 			.addScripts("databases/H2/schema.sql", "databases/H2/data.sql")
	// 			.build();
	// 	} catch (Exception e) {
	// 		LOGGER.error("Embedded dataSource bean cannot be created!", e);
	// 		return null;
	// 	}
	// }
}