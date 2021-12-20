package com.example.helloworld.database.springjdbc.jdbctemplate;

import java.util.*;

import com.example.helloworld.database.plainjdbc.*;

import org.slf4j.*;
import org.springframework.beans.factory.*;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcTemplateSingerDao implements SingerDao, InitializingBean {
    private static Logger logger;

    static {
		logger = LoggerFactory.getLogger(JdbcTemplateSingerDao.class);
	}

    private JdbcTemplate jdbcTemplate;
    
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
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
            logger.error("Problem when executing SELECT.", e);
            return null;
		}
    }

	@Override
	public Singer findById(Long id) {
		String sql = "select * from singer where id = ?";
		try {
			return jdbcTemplate.queryForObject(sql, new SingerRowMapper(), id);
		} catch (DataAccessException e) {
			logger.error("Problem when executing SELECT.", e);
            return null;
		}
	}

    @Override
	public void insert(Singer singer) {
		String sql = "insert into singer " + 
			"(first_name, last_name, birth_date) " + "values (?, ?, ?)";
		try {
			jdbcTemplate.update(sql, singer.getFirstName(), 
				singer.getLastName(), singer.getBirthDate());
		} catch (DataAccessException e) {
			logger.error("Problem when executing INSERT.", e);
		}
	}

	@Override
	public void deleteById(Long singerId) {
		String sql = "delete from singer where id=?";
		try {
			jdbcTemplate.update(sql, singerId);
		} catch (DataAccessException e) {
			logger.error("Problem when executing DELETE.", e);
		}
	}
}