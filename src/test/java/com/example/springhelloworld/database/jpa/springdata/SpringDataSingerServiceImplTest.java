package com.example.springhelloworld.database.jpa.springdata;

import static org.junit.Assert.assertEquals;

import java.util.*;

import com.example.springhelloworld.database.jpa.JpaConfig;
import com.example.springhelloworld.database.jpa.entities.Singer;

import org.junit.*;
import org.slf4j.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

public class SpringDataSingerServiceImplTest {
    private static final Logger LOGGER = 
        LoggerFactory.getLogger(SpringDataSingerServiceImplTest.class);
    
    private GenericApplicationContext context;
    private SpringDataSingerService singerService;

    @Before
    public void init() {
        context = new AnnotationConfigApplicationContext(JpaConfig.class);
        singerService = context.getBean("springDataJpaSingerService", SpringDataSingerService.class);
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
    public void testFindById() {
        Singer singer = singerService.findById(1l);
        LOGGER.info(singer.toSimpleString());
        assertEquals("John", singer.getFirstName());
    }

    @Test
    public void testFindSingerByAuditRevisionNumber() {
        singerService.save(
            createSingerWithBasicInfo("Tony", "Morning", generateDate(1940, 8, 16)));

        Singer insertedSinger = singerService.findSingerByAuditRevisionNumber(4l, 1);
        LOGGER.info(insertedSinger.toSimpleString());
        assertEquals("Tony", insertedSinger.getFirstName());
    }

    @Test
    public void testFindByFirstName() {
        List<Singer> singers = singerService.findByFirstName("John");
        for (Singer singer : singers) LOGGER.info(singer.toSimpleString());
        assertEquals(2, singers.size());
    }

    @Test
    public void testFindByFirstNameAndLastName() {
        List<Singer> singers = 
            singerService.findByFirstNameAndLastName("Eric", "Clapton");
        for (Singer singer : singers) LOGGER.info(singer.toSimpleString());
        assertEquals(1, singers.size());
    }

    @Test
    public void testSave() {
        Singer singer = createSingerWithBasicInfo("BB", "King", generateDate(1940, 8, 16));
        singerService.save(singer);
        LOGGER.info(singer.toSimpleString());
        assertEquals(4, singerService.findAll().size());
    }

    private Singer createSingerWithBasicInfo(String fname, String lname, Date dob) {
        Singer singer = new Singer();
        singer.setFirstName(fname);
        singer.setLastName(lname);
        singer.setBirthDate(dob);
        return singer;
    }

    private Date generateDate(int year, int month, int date) {
        return new Date(new GregorianCalendar(year, month, date)
            .getTimeInMillis());
    }

    @Test
    public void testUpdate() {
        Singer singer = singerService.findById(1l);
        singer.setFirstName("John Clayton");
        singerService.save(singer);
        LOGGER.info(singer.toSimpleString());
        assertEquals("John Clayton", singerService.findById(1l).getFirstName());
    }
}