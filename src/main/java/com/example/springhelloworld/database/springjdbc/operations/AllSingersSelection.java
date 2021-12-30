package com.example.springhelloworld.database.springjdbc.operations;

import java.sql.*;

import javax.sql.DataSource;

import com.example.springhelloworld.database.plainjdbc.Singer;
import com.example.springhelloworld.database.springjdbc.jdbctemplate.SingerRowMapper;

import org.springframework.jdbc.object.MappingSqlQuery;

public class AllSingersSelection extends MappingSqlQuery<Singer> {
    private static final String SQL = "select * from singer";
    
    public AllSingersSelection(DataSource dataSource) {
        super(dataSource, SQL);
    }

    @Override
    protected Singer mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new SingerRowMapper().mapRow(rs, rowNum);
    }
}