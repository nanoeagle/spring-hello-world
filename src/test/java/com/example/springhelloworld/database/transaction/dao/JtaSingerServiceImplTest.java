package com.example.springhelloworld.database.transaction.dao;

import static org.junit.Assert.assertEquals;

import java.util.*;

import com.example.springhelloworld.database.transaction.*;
import com.example.springhelloworld.database.transaction.entities.Singer;

import org.junit.*;
import org.slf4j.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

public class JtaSingerServiceImplTest {
    private static final Logger LOGGER = 
        LoggerFactory.getLogger(SingerServiceImplTest.class);
    
    private GenericApplicationContext context;
    private SingerService singerService;
    
    @Before
    public void init() {
        context = new AnnotationConfigApplicationContext(XAJpaConfig.class, XAServiceConfig.class);
        singerService = context.getBean("jtaSingerService", SingerService.class);
    }
    
    @After
    public void releaseContext() {
        if (context != null) context.close();
    }
    
    @Test
    public void testFindAll() {
        List<Singer> singers = singerService.findAll();
        for (Singer singer : singers) LOGGER.info(singer.toSimpleString());
        assertEquals(8, singers.size());
    }
    
    @Test
    public void testCountAll() {
        assertEquals(8, singerService.countAll());
    }
    
    @Test
    public void testSave() {
        Singer singer = new Singer();
        singer.setFirstName("Johnn");
        singer.setLastName("Henry");
        singer.setBirthDate(new Date(
            new GregorianCalendar(1987, 3, 12).getTimeInMillis()));
        singerService.save(singer);
        if (singer.getId() != null) {
            LOGGER.info("Singer saved successfully");
        } else {
            LOGGER.info("Singer was not saved, check the configuration!");
        }
    }
}