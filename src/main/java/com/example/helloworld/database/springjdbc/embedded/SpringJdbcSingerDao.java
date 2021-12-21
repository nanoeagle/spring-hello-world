package com.example.helloworld.database.springjdbc.embedded;

import java.sql.*;
import java.util.*;

import javax.sql.DataSource;

import com.example.helloworld.database.plainjdbc.*;

import org.slf4j.*;
import org.springframework.beans.factory.*;

public class SpringJdbcSingerDao implements SingerDao, InitializingBean {
    private static Logger logger;

    static {
		logger = LoggerFactory.getLogger(SpringJdbcSingerDao.class);
	}

    private DataSource dataSource;
    
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if (dataSource == null)
            throw new BeanCreationException("Must set dataSource on SingerDao");
    }

    @Override
	public List<Singer> findAll() {
		List<Singer> result = null;
		String sql = "select * from singer";
		try (Connection connection = dataSource.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery()
		) {
			result = createTheResultFrom(resultSet);
		} catch (SQLException e) {
			logger.error("Problem when executing SELECT.", e);
		} catch (RuntimeException e) {
			logger.error("Problem when adding a singer to the result.", e);
		}
		return result;
	}

	private List<Singer> createTheResultFrom(ResultSet resultSet) 
	throws SQLException {
		List<Singer> result = new ArrayList<>();
		while (resultSet.next()) {
			Singer singer = new Singer();
			singer.setId(resultSet.getLong("id"));
			singer.setFirstName(resultSet.getString("first_name"));
			singer.setLastName(resultSet.getString("last_name"));
			singer.setBirthDate(resultSet.getDate("birth_date"));
			result.add(singer);
		}
		return result;
	}

	@Override
	public List<Singer> findAllWithAlbums() {
		return null;
	}

	@Override
	public Singer findById(Long id) {
		Singer result = null;
		String sql = "select * from singer where id = ?";
		try (Connection connection = dataSource.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
		) {
			statement.setLong(1, id);
			result = extractSingerFrom(statement.executeQuery());
		} catch (SQLException e) {
			logger.error("Problem when executing SELECT.", e);
		}
		return result;
	}

	private Singer extractSingerFrom(ResultSet resultSet) throws SQLException {
		if (resultSet.next()) {
			Singer singer = new Singer();
			singer.setId(resultSet.getLong("id"));
			singer.setFirstName(resultSet.getString("first_name"));
			singer.setLastName(resultSet.getString("last_name"));
			singer.setBirthDate(resultSet.getDate("birth_date"));
			return singer;
		}
		return null;
	}

    @Override
	public void insert(Singer singer) {
		String sql = "insert into singer (first_name, last_name, birth_date)"
			+ " values (?, ?, ?)";
		int returnGeneratedKeys = Statement.RETURN_GENERATED_KEYS;
		try (Connection connection = dataSource.getConnection();
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
	public void deleteById(Long singerId) {
		String sql = "delete from singer where id=?";
		try (Connection connection = dataSource.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
		) {
			statement.setLong(1, singerId);
			statement.execute();
		} catch (SQLException e) {
			logger.error("Problem when executing DELETE.", e);
		}
	}
}