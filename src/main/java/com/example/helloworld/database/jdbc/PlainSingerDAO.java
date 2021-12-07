package com.example.helloworld.database.jdbc;

import java.sql.*;
import java.util.*;

import org.slf4j.*;

public class PlainSingerDAO implements SingerDAO {
	private static Logger logger;
	
	static {
		logger = LoggerFactory.getLogger(PlainSingerDAO.class);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			logger.error("Problem loading DB driver!", e);
		}
	}

	@Override
	public Set<Singer> findAll() {
		Set<Singer> result = new TreeSet<>(new SingerIDComparator());
		String sql = "select * from singer";
		try (Connection connection = getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery()
		) {
			addAllSingersToResult(resultSet, result);
		} catch (SQLException e) {
			logger.error("Problem when executing SELECT.", e);
		} catch (Exception e) {
			logger.error("Problem when adding a singer to the result.", e);
		}
		return result;
	}

	private void addAllSingersToResult(ResultSet resultSet, Set<Singer> result) 
	throws SQLException {
		while (resultSet.next()) {
			Singer singer = new Singer();
			singer.setId(resultSet.getLong("id"));
			singer.setFirstName(resultSet.getString("first_name"));
			singer.setLastName(resultSet.getString("last_name"));
			singer.setBirthDate(resultSet.getDate("birth_date"));
			result.add(singer);
		}
	}

	@Override
	public void insert(Singer singer) {
		String sql = "insert into singer (first_name, last_name, birth_date)"
			+ " values (?, ?, ?)";
		int returnGeneratedKeys = Statement.RETURN_GENERATED_KEYS;
		try (Connection connection = getConnection();
			PreparedStatement statement = 
				connection.prepareStatement(sql, returnGeneratedKeys);
		) {
			insertSingerToDatabase(statement, singer);
		} catch (SQLException e) {
			logger.error("Problem when executing INSERT.", e);
		}
	}

	private void insertSingerToDatabase(PreparedStatement statement, Singer singer) 
	throws SQLException {
		statement.setString(1, singer.getFirstName());
		statement.setString(2, singer.getLastName());
		statement.setDate(3, singer.getBirthDate());
		statement.execute();
		ResultSet generatedKeys = statement.getGeneratedKeys();
		if (generatedKeys.next()) singer.setId(generatedKeys.getLong(1));
	}

	@Override
	public void delete(Long singerId) {
		String sql = "delete from singer where id=?";
		try (Connection connection = getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
		) {
			statement.setLong(1, singerId);
			statement.execute();
		} catch (SQLException e) {
			logger.error("Problem when executing DELETE.", e);
		}
	}

	private Connection getConnection() throws SQLException {
		return DriverManager.getConnection(
			"jdbc:mysql://localhost:3306/musicdb?useSSL=true",
			"root", "mysql");
	}

	private class SingerIDComparator implements Comparator<Singer> {
		@Override
		public int compare(Singer s1, Singer s2) {
			return (int) (s1.getId() - s2.getId());
		}
	}
}