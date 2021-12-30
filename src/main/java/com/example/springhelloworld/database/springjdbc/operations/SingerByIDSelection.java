package com.example.springhelloworld.database.springjdbc.operations;

import java.sql.*;

import javax.sql.DataSource;

import com.example.springhelloworld.database.plainjdbc.*;
import com.example.springhelloworld.database.springjdbc.jdbctemplate.SingerRowMapper;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.MappingSqlQuery;

public class SingerByIDSelection extends MappingSqlQuery<Singer> {
    private static final String SQL = 
        "select * from singer where id = :id";

    public SingerByIDSelection(DataSource dataSource) {
        super(dataSource, SQL);
        declareParameter(new SqlParameter("id", Types.VARCHAR));
    }

    @Override
    protected Singer mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new SingerRowMapper().mapRow(rs, rowNum);
    }
}