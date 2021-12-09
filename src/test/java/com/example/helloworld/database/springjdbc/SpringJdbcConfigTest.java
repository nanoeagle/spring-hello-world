package com.example.helloworld.database.springjdbc;

import static org.junit.Assert.*;

import java.sql.*;

import javax.sql.DataSource;

import org.junit.*;
import org.slf4j.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

public class SpringJdbcConfigTest {
	private static Logger logger; 
	
	static {
		logger = LoggerFactory.getLogger(SpringJdbcConfig.class);
	}

	@Test
	public void testConfig() {
		GenericApplicationContext context =
			new AnnotationConfigApplicationContext(SpringJdbcConfig.class);
		DataSource dataSource = 
			context.getBean("dataSource", DataSource.class);
		assertNotNull(dataSource);
		testDataSource(dataSource);
		context.close();
	}

	private void testDataSource(DataSource dataSource) {
		String sql = "SELECT 1";
		try (Connection connection = dataSource.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery()
		) {
			while (resultSet.next()) {
				int mockValue = resultSet.getInt(1);
				assertTrue(mockValue == 1);
			}
		} catch (Exception e) {
			String errorMessage = "Something unexpected happened.";
			logger.debug(errorMessage, e);
			fail(errorMessage);
		}
	}
}