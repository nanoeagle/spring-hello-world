package com.example.springhelloworld.database.hibernate.dao;

import static org.junit.Assert.*;

import java.util.*;

import com.example.springhelloworld.database.hibernate.HibernateConfig;
import com.example.springhelloworld.database.hibernate.entities.*;

import org.junit.*;
import org.slf4j.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

public class HibernateSingerDaoTest {
    private static final Logger LOGGER = 
        LoggerFactory.getLogger(HibernateSingerDaoTest.class);
    
    private GenericApplicationContext context;
    private SingerDao singerDao;
    private InstrumentDao instrumentDao;

    @Before
    public void init() {
        context = new AnnotationConfigApplicationContext(HibernateConfig.class);
        singerDao = context.getBean("singerDao", SingerDao.class);
        instrumentDao = context.getBean("instrumentDao", InstrumentDao.class);
    }
    
    @After
    public void releaseContext() {
        if (context != null) context.close();
    }
    
    @Test
    public void testFindAll() {
        List<Singer> allSingers = singerDao.findAll();
        for (Singer singer : allSingers) LOGGER.info(singer.toSimpleString());
        assertEquals(3, allSingers.size());
    }

    @Test
    public void testFindAllWithAssociations() {
        List<Singer> allSingers = singerDao.findAllWithAssociations();
        for (Singer singer : allSingers) LOGGER.info(singer.toString());
        assertEquals(3, allSingers.size());
    }

    @Test
    public void testFindById() {
        Singer singer = singerDao.findById(1l);
        LOGGER.info(singer.toString());
        assertEquals("John", singer.getFirstName());
    }

    @Test
    public void testInsert() {
        Singer mockSinger = createMockSinger();
        singerDao.save(mockSinger);
        LOGGER.info(singerDao.findById(mockSinger.getId()).toString());
        assertEquals(4, singerDao.findAll().size());
    }

    private Singer createMockSinger() {
        Singer singer = new Singer();
        singer.setFirstName("BB");
        singer.setLastName("King");
        singer.setBirthDate(new Date(
            (new GregorianCalendar(1940, 8, 16)).getTimeInMillis()));
        
        Album album = new Album();
        album.setTitle("My Kind of Blues");
        album.setReleaseDate(new Date(
            (new GregorianCalendar(1961, 7, 18)).getTimeInMillis()));
        singer.addAlbum(album);

        album = new Album();
        album.setTitle("A Heart Full of Blues");
        album.setReleaseDate(new Date(
            (new GregorianCalendar(1962, 3, 20)).getTimeInMillis()));
        singer.addAlbum(album);

        Instrument violin = instrumentDao.findByName("Violin");
        Instrument cello = instrumentDao.findByName("Cello");
        if (violin == null) {
            violin = new Instrument();
            violin.setName("Violin");
        }
        if (cello == null) {
            cello = new Instrument();
            cello.setName("Cello");
        }
        singer.setInstruments(Set.of(violin, cello));
        return singer;
    }

    @Test
    public void testUpdate() {
        Singer singer = singerDao.findById(1l);
        Album album = singer.getAlbums().stream().filter(
            a -> a.getTitle().equals("Battle Studies")).findFirst().get();
        singer.setFirstName("John Clayton");
        singer.removeAlbum(album);
        singerDao.save(singer);
        
        singer = singerDao.findById(1l);
        LOGGER.info(singer.toString());
        assertEquals("John Clayton", singer.getFirstName());
        assertFalse(singer.getAlbums().contains(album));
    }

    @Test
    public void testDelete() {
        Singer singer = singerDao.findById(1l);
        singerDao.delete(singer);
        assertNull(singerDao.findById(1l));
    }
}