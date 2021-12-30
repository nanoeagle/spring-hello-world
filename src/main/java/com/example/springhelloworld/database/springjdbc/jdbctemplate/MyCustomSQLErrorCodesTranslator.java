package com.example.springhelloworld.database.springjdbc.jdbctemplate;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.dao.*;
import org.springframework.jdbc.support.SQLErrorCodeSQLExceptionTranslator;

public class MyCustomSQLErrorCodesTranslator extends SQLErrorCodeSQLExceptionTranslator {
    public MyCustomSQLErrorCodesTranslator(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    protected DataAccessException customTranslate(String task, String sql, 
    SQLException sqlEx) {
        if (sqlEx.getErrorCode() == -12345) 
            return new DeadlockLoserDataAccessException(task, sqlEx);
        return null;
    }
}