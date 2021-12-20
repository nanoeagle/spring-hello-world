package com.example.helloworld.database.springjdbc.jdbctemplate;

import java.sql.*;

import com.example.helloworld.database.plainjdbc.Singer;

import org.springframework.jdbc.core.RowMapper;

public class SingerRowMapper implements RowMapper<Singer> {
    @Override
    public Singer mapRow(ResultSet rs, int rowNum) throws SQLException {
        Singer singer = new Singer();
        singer.setId(rs.getLong("id"));
        singer.setFirstName(rs.getString("first_name"));
        singer.setLastName(rs.getString("last_name"));
        singer.setBirthDate(rs.getDate("birth_date"));
        return singer;
    }
}