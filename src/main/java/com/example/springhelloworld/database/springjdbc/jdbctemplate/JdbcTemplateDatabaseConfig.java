package com.example.springhelloworld.database.springjdbc.jdbctemplate;

// import javax.sql.DataSource;

// import com.example.springhelloworld.database.plainjdbc.SingerDao;

// import org.slf4j.*;
// import org.springframework.context.annotation.*;
// import org.springframework.jdbc.core.JdbcTemplate;
// import org.springframework.jdbc.datasource.embedded.*;

// @ImportResource("appContextConfigs/app-context-database-spring-jdbc-template.xml")
// @Configuration
public class JdbcTemplateDatabaseConfig {
	// private static Logger LOGGER =
	// 	LoggerFactory.getLogger(JdbcTemplateDatabaseConfig.class);
	
	// @Bean
	// public SingerDao singerDao() {
	// 	JdbcTemplate template = new JdbcTemplate(dataSource());
	// 	template.setExceptionTranslator(
	// 		new MyCustomSQLErrorCodesTranslator(template.getDataSource()));
	// 	JdbcTemplateSingerDao dao = new JdbcTemplateSingerDao();
	// 	dao.setJdbcTemplate(template);
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