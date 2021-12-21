package com.example.helloworld.database.springjdbc.jdbctemplate.namedparameters;

import com.example.helloworld.database.plainjdbc.SingerDao;
import com.example.helloworld.database.springjdbc.jdbctemplate.JdbcTemplateSingerDaoTest;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class NamedParameterJdbcTemplateSingerDaoTest 
extends JdbcTemplateSingerDaoTest {
    @Override
    public void init() {
        context = new AnnotationConfigApplicationContext(
            NamedParameterJdbcTemplateDatabaseConfig.class);
        singerDao = context.getBean("singerDao", SingerDao.class);
    }
}