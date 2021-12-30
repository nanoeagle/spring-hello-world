package com.example.springhelloworld.database.plainjdbc;

import java.sql.*;
import java.util.*;

import org.slf4j.*;

public class PlainSingerDao implements SingerDao {
	private static final Logger LOGGER;
	
	static {
		LOGGER = LoggerFactory.getLogger(PlainSingerDao.class);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			LOGGER.error("Problem loading DB driver!", e);
		}
	}

	@Override
	public List<Singer> findAll() {
		List<Singer> result = null;
		String sql = "select * from singer";
		try (Connection connection = getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery()
		) {
			result = createTheResultFrom(resultSet);
		} catch (SQLException e) {
			LOGGER.error("Problem when executing SELECT.", e);
		} catch (RuntimeException e) {
			LOGGER.error("Problem when adding a singer to the result.", e);
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
		List<Singer> result = null;
		String sql = "select s.id, s.first_name, s.last_name, s.birth_date"
 			+ ", a.id as album_id, a.title, a.release_date from singer s "
 			+ "left join album a on s.id = a.singer_id";
		try (Connection connection = getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery()
		) {
			result = createTheResultWithAlbumsFrom(resultSet);
		} catch (SQLException e) {
			LOGGER.error("Problem when executing SELECT.", e);
		}
		return result;
	}

	private List<Singer> createTheResultWithAlbumsFrom(ResultSet rs)
	throws SQLException {
		Map<Long, Singer> singerMap = new HashMap<>();
		while (rs.next()) {
            Singer singer = addNewSingerToMapIfNonExistent(rs, singerMap);
            addAlbumToSingerIfFound(rs, singer);
        }
        return new ArrayList<>(singerMap.values());
    }

    private Singer addNewSingerToMapIfNonExistent(ResultSet rs, 
	Map<Long, Singer> singerMap) throws SQLException  {
        Long singerId = rs.getLong("id");
        Singer singer = singerMap.get(singerId);
        if (singer == null) {
            singer = createNewSingerUsing(rs);
            singerMap.put(singerId, singer);
        }
        return singer;
    }

    private Singer createNewSingerUsing(ResultSet rs) throws SQLException {
        Singer singer = new Singer();
        singer.setId(rs.getLong("id"));
        singer.setFirstName(rs.getString("first_name"));
        singer.setLastName(rs.getString("last_name"));
        singer.setBirthDate(rs.getDate("birth_date"));
        singer.setAlbums(new HashSet<>());
        return singer;
    }

    private void addAlbumToSingerIfFound(ResultSet rs, Singer singer) 
    throws SQLException {
        Long albumId = rs.getLong("album_id");
        if (albumId > 0) {
            Album album = new Album();
            album.setId(albumId);
            album.setSingerId(singer.getId());
            album.setTitle(rs.getString("title"));
            album.setReleaseDate(rs.getDate("release_date"));
            singer.addAlbum(album);
        }
    }

	@Override
	public Singer findById(Long id) {
		Singer result = null;
		String sql = "select * from singer where id = ?";
		try (Connection connection = getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
		) {
			statement.setLong(1, id);
			result = extractSingerFrom(statement.executeQuery());
		} catch (SQLException e) {
			LOGGER.error("Problem when executing SELECT.", e);
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
		try (Connection connection = getConnection();
			PreparedStatement statement = 
				connection.prepareStatement(sql, returnGeneratedKeys);
		) {
			insertSingerToDatabase(statement, singer);
		} catch (SQLException e) {
			LOGGER.error("Problem when executing INSERT.", e);
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
		try (Connection connection = getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
		) {
			statement.setLong(1, singerId);
			statement.execute();
		} catch (SQLException e) {
			LOGGER.error("Problem when executing DELETE.", e);
		}
	}

	private Connection getConnection() throws SQLException {
		return DriverManager.getConnection(
			"jdbc:mysql://localhost:3306/musicdb?useSSL=true",
			"root", "mysql");
	}
}