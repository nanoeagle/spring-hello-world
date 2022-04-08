package com.example.springhelloworld.database.jpa.springdata.springboot;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;

import com.example.springhelloworld.database.jpa.entities.Singer;
import com.example.springhelloworld.database.jpa.springdata.SpringDataSingerRepository;

import org.junit.*;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication(scanBasePackages = "com.example.springhelloworld.database.jpa")
public class DataJPASpringBootTest {
    private static final Logger LOGGER = 
        LoggerFactory.getLogger(DataJPASpringBootTest.class);

    private ConfigurableApplicationContext context;
    
    @Autowired
    private SpringDataSingerRepository singerRepository;

    @Before
    public void init() {
        context = SpringApplication.run(DataJPASpringBootTest.class);
    }

    @After
    public void releaseContext() {
        if (context != null) context.close();
    }

    @Test
    public void testDB() {
        Set<Singer> singers = new HashSet<>();
        for (Singer singer : singerRepository.findAll()) {
            singers.add(singer);
            LOGGER.info(singer.toSimpleString());
        } 
        assertEquals(1, singers.size());
    }
}