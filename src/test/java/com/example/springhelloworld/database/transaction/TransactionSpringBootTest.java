package com.example.springhelloworld.database.transaction;

import java.util.*;

import javax.annotation.Resource;

import com.example.springhelloworld.database.transaction.dao.SingerService;
import com.example.springhelloworld.database.transaction.entities.Singer;

import org.junit.*;
import org.slf4j.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication(scanBasePackages = "com.example.springhelloworld.database.transaction")
public class TransactionSpringBootTest {
    private static final Logger LOGGER = 
        LoggerFactory.getLogger(TransactionSpringBootTest.class);

    private ConfigurableApplicationContext context;
    
    @Resource(name = "springBootSingerService")
    private SingerService singerService;

    @Before
    public void init() {
        context = SpringApplication.run(TransactionSpringBootTest.class);
    }

    @After
    public void releaseContext() {
        if (context != null) context.close();
    }

    @Test
    public void testSave() {
        Singer singer = new Singer();
        singer.setFirstName("Johnn");
        singer.setLastName("Wick");
        singer.setBirthDate(new Date(
            new GregorianCalendar(1987, 3, 12).getTimeInMillis()));
        singerService.save(singer);
        if (singer.getId() != null) {
            LOGGER.info("Singer saved successfully");
        } else {
            LOGGER.error("Singer was not saved, check the configuration!");
        }
    }
}