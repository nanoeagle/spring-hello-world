package com.example.helloworld.database.springjdbc.jdbctemplate.namedparameters;

// import com.example.helloworld.database.plainjdbc.SingerDao;
import com.example.helloworld.database.springjdbc.jdbctemplate.JdbcTemplateDatabaseConfig;

// import org.springframework.context.annotation.*;
// import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

// @ImportResource("appContextConfigs/app-context-database-spring-jdbc-namedparam-template.xml")
// @Configuration
public class NamedParameterJdbcTemplateDatabaseConfig 
extends JdbcTemplateDatabaseConfig {
	// @Override
	// public SingerDao singerDao() {
	// 	NamedParameterJdbcTemplate template = 
	// 		new NamedParameterJdbcTemplate(dataSource());
	// 	NamedParameterJdbcTemplateSingerDao dao = 
	// 		new NamedParameterJdbcTemplateSingerDao();
	// 	dao.setJdbcTemplate(template);
	// 	return dao;
	// }
}