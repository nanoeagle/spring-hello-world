package com.example.springhelloworld.database.springjdbc.jdbctemplate.namedparameters;

import java.util.*;

import com.example.springhelloworld.database.plainjdbc.*;
import com.example.springhelloworld.database.springjdbc.jdbctemplate.*;

import org.slf4j.*;
import org.springframework.beans.factory.*;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public class NamedParameterJdbcTemplateSingerDao 
implements SingerDao, InitializingBean {
    private static final Logger LOGGER;

    static {
		LOGGER = LoggerFactory.getLogger(
			NamedParameterJdbcTemplateSingerDao.class);
	}

    private NamedParameterJdbcTemplate jdbcTemplate;
    
    public void setJdbcTemplate(NamedParameterJdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

    @Override
    public void afterPropertiesSet() throws Exception {
        if (jdbcTemplate == null) throw new BeanCreationException(
			"Must set jdbcTemplate on SingerDao");
    }

    @Override
    public List<Singer> findAll() {
        String sql = "select * from singer";
		try {
			return jdbcTemplate.query(sql, new SingerRowMapper());
		} catch (DataAccessException e) {
            LOGGER.error("Problem when executing SELECT.", e);
            return null;
		}
    }

	@Override
	public List<Singer> findAllWithAlbums() {
		String sql = "select s.id, s.first_name, s.last_name, s.birth_date"
 			+ ", a.id as album_id, a.title, a.release_date from singer s "
 			+ "left join album a on s.id = a.singer_id";
		try {
			return jdbcTemplate.query(sql, new SingerWithAlbumsExtractor());
		} catch (DataAccessException e) {
            LOGGER.error("Problem when executing SELECT.", e);
            return null;
		}
	}

	@Override
	public Singer findById(Long id) {
		String sql = "select * from singer where id = :id";
		try {
			return jdbcTemplate.queryForObject(sql, 
				createParamMapHaving(id), new SingerRowMapper());
		} catch (DataAccessException e) {
			LOGGER.error("Problem when executing SELECT.", e);
            return null;
		}
	}

    private Map<String, String> createParamMapHaving(Long id) {
		Map<String, String> paramMap = new HashMap<>();
		paramMap.put("id", id.toString());
		return paramMap;
	}

	@Override
	public void insert(Singer singer) {
		String sql = "insert into singer " + 
			"(first_name, last_name, birth_date) " + 
			"values (:fName, :lName, :dob)";
		try {
			jdbcTemplate.update(sql, createParamMapUsing(singer));
		} catch (DataAccessException e) {
			LOGGER.error("Problem when executing INSERT.", e);
		}
	}

	private Map<String, String> createParamMapUsing(Singer singer) {
		Map<String, String> paramMap = new HashMap<>();
		paramMap.put("fName", singer.getFirstName());
		paramMap.put("lName", singer.getLastName());
		paramMap.put("dob", singer.getBirthDate().toString());
		return paramMap;
	}

	@Override
	public void deleteById(Long id) {
		String deleteFromAlbum = "delete from album where singer_id = :id";
		String deleteFromSinger = "delete from singer where id = :id";
		try {
			Map<String, String> paramMap = createParamMapHaving(id);
			jdbcTemplate.update(deleteFromAlbum, paramMap);
			jdbcTemplate.update(deleteFromSinger, paramMap);
		} catch (DataAccessException e) {
			LOGGER.error("Problem when executing DELETE.", e);
		}
	}
}