package com.example.helloworld.database.springjdbc.datasource;

import static org.junit.Assert.*;

import java.sql.*;

import javax.sql.DataSource;

import org.junit.*;
import org.slf4j.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

public class SpringJdbcConfigTest {
	private static final Logger LOGGER; 
	private GenericApplicationContext context;
	private DataSource dataSource;

	static {
		LOGGER = LoggerFactory.getLogger(SpringJdbcConfigTest.class);
	}

	@Before
	public void init() {
		context = new AnnotationConfigApplicationContext(SpringJdbcConfig.class);
		dataSource = context.getBean("dataSource", DataSource.class);
	}

	@After
	public void releaseContext() {
		context.close();
	}

	@Test
	public void testDataSource() {
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
			LOGGER.debug(errorMessage, e);
			fail(errorMessage);
		}
	}
}