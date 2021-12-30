package com.example.springhelloworld.database.springjdbc.operations;

import java.sql.*;
import java.util.*;

import javax.annotation.Resource;
import javax.sql.DataSource;

import com.example.springhelloworld.database.plainjdbc.*;

import org.slf4j.*;
import org.springframework.beans.factory.*;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository("singerDao")
public class SpringJdbcOpsSingerDao implements SingerDao, InitializingBean {
    private static final Logger LOGGER;

    static {
        LOGGER = LoggerFactory.getLogger(SpringJdbcOpsSingerDao.class);
    }

    private DataSource dataSource;
    private AllSingersSelection allSingersSelection;
    private AllSingersWithAlbumsSelection allSingersWithAlbumsSelection;
    private SingerByIDSelection singerByIDSelection;
    private SingerInsertion singerInsertion;
    
    @Resource(name = "dataSource")
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if (dataSource == null)
            throw new BeanCreationException("Must set dataSource on SingerDao");
        allSingersSelection = new AllSingersSelection(dataSource);
        allSingersWithAlbumsSelection = 
            new AllSingersWithAlbumsSelection(dataSource);
        singerByIDSelection = new SingerByIDSelection(dataSource);
        singerInsertion = new SingerInsertion(dataSource);
    }

    @Override
    public List<Singer> findAll() {
        try {
            return allSingersSelection.execute();
        } catch (DataAccessException e) {
            LOGGER.error("Problem when executing SELECT.", e);
            return null;
        }
    }

    @Override
    public List<Singer> findAllWithAlbums() {
        try {
            return allSingersWithAlbumsSelection.execute();
        } catch (DataAccessException e) {
            LOGGER.error("Problem when executing SELECT.", e);
            return null;
        }
    }

    @Override
    public Singer findById(Long id) {
        try {
            return singerByIDSelection
                .executeByNamedParam(Map.of("id", id)).get(0);
        } catch (RuntimeException e) {
            LOGGER.error("Problem when executing SELECT.", e);
            return null;
        }
    }

    @Override
    public void insert(Singer singer) {
        Map<String, Object> paramMap = createParamMapFrom(singer);
        KeyHolder keyHolder = new GeneratedKeyHolder();
        try {
            singerInsertion.updateByNamedParam(paramMap, keyHolder);
            singer.setId(keyHolder.getKey().longValue());
        } catch (DataAccessException e) {
            LOGGER.error("Problem when executing INSERT.", e);
        }
    }

    private Map<String, Object> createParamMapFrom(Singer singer) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("first_name", singer.getFirstName());
        paramMap.put("last_name", singer.getLastName());
        paramMap.put("birth_date", singer.getBirthDate());
        return paramMap;
    }
    
    @Override
    public void deleteById(Long singerId) {
        String deleteFromAlbum = "delete from album where singer_id=?";
		String deleteFromSinger = "delete from singer where id=?";
        try (Connection connection = dataSource.getConnection();
            PreparedStatement sql1 = connection.prepareStatement(deleteFromAlbum);
            PreparedStatement sql2 = connection.prepareStatement(deleteFromSinger);
        ) {
            sql1.setLong(1, singerId);
            sql1.execute();
            sql2.setLong(1, singerId);
            sql2.execute();
        } catch (SQLException e) {
            LOGGER.error("Problem when executing DELETE.", e);
        }
    }
}