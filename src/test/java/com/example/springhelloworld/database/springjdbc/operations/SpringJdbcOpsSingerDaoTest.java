package com.example.springhelloworld.database.springjdbc.operations;

import com.example.springhelloworld.database.plainjdbc.SingerDao;
import com.example.springhelloworld.database.springjdbc.jdbctemplate.JdbcTemplateSingerDaoTest;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringJdbcOpsSingerDaoTest extends JdbcTemplateSingerDaoTest {
    @Override
    public void init() {
        context = new AnnotationConfigApplicationContext(
            SpringJdbcOpsDatabaseConfig.class);
        singerDao = context.getBean("singerDao", SingerDao.class);
    }
}