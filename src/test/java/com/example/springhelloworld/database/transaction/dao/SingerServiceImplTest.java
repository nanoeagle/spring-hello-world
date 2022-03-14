package com.example.springhelloworld.database.transaction.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import com.example.springhelloworld.database.transaction.*;
import com.example.springhelloworld.database.transaction.entities.Singer;

import org.junit.*;
import org.slf4j.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

public class SingerServiceImplTest {
    private static final Logger LOGGER = 
        LoggerFactory.getLogger(SingerServiceImplTest.class);
    
    private GenericApplicationContext context;
    private SingerService singerService;
    
    @Before
    public void init() {
        context = new AnnotationConfigApplicationContext(DBConfig.class, ServiceConfig.class);
        singerService = context.getBean("transactionalSingerService", SingerService.class);
    }
    
    @After
    public void releaseContext() {
        if (context != null) context.close();
    }

    @Test
    public void testFindAll() {
        List<Singer> singers = singerService.findAll();
        for (Singer singer : singers) LOGGER.info(singer.toSimpleString());
        assertEquals(3, singers.size());
    }

    @Test
    public void testCountAll() {
        assertEquals(3, singerService.countAll());
    }
}