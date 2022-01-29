package com.example.springhelloworld.database.jpa.services;

import static org.junit.Assert.*;

import java.util.*;

import javax.persistence.NoResultException;

import com.example.springhelloworld.database.jpa.entities.*;
import com.example.springhelloworld.database.jpa.pojos.SingerWithLatestAlbum;
import com.example.springhelloworld.database.jpa.JpaConfig;

import org.junit.*;
import org.slf4j.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

public class SingerServiceImplTest {
    private static final Logger LOGGER = 
        LoggerFactory.getLogger(SingerServiceImplTest.class);
    
    private GenericApplicationContext context;
    private SingerService singerService;
    private InstrumentService instrumentService;

    @Before
    public void init() {
        context = new AnnotationConfigApplicationContext(JpaConfig.class);
        singerService = context.getBean("jpaSingerService", SingerService.class);
        instrumentService = context.getBean("jpaInstrumentService", InstrumentService.class);
    }
    
    @After
    public void releaseContext() {
        if (context != null) context.close();
    }
    
    @Test
    public void testFindAll() {
        List<Singer> allSingers = singerService.findAll();
        for (Singer singer : allSingers) LOGGER.info(singer.toSimpleString());
        assertEquals(3, allSingers.size());
    }

    @Test
    public void testFindAllWithAssociations() {
        List<Singer> allSingers = singerService.findAllWithAssociations();
        for (Singer singer : allSingers) LOGGER.info(singer.toString());
        assertEquals(3, allSingers.size());
    }

    /* @Test
    public void testFindAllWithLatestAlbum() {
        List<Object[]> objectArrays = singerService.findAllWithLatestAlbum();
        for (Object[] objArr : objectArrays) LOGGER.info("Singer ID - " 
            + objArr[0] + ": " + objArr[1] + " " + objArr[2] 
            + ", most recent album: " + objArr[3]);
        assertEquals(2, objectArrays.size());
    } */

    @Test
    public void testFindAllWithLatestAlbum() {
        List<SingerWithLatestAlbum> singers = singerService.findAllWithLatestAlbum();
        for (SingerWithLatestAlbum singer : singers) LOGGER.info(singer.toString());
        assertEquals(2, singers.size());
    }

    @Test
    public void testFindAllByNativeQuery() {

    }

    @Test
    public void testFindById() {
        Singer singer = singerService.findById(1l);
        LOGGER.info(singer.toString());
        assertEquals("John", singer.getFirstName());
    }

    @Test
    // fails when saving multiple singers with the same instruments to MySQL 
    // (and probably also to H2).
    public void testSave() {
        Singer mockSinger1 = createMockSinger("BB", "King", generateDate(1940, 8, 16));
        Singer mockSinger2 = createMockSinger("Tony", "King", generateDate(1939, 9, 16));
        singerService.save(mockSinger1);
        singerService.save(mockSinger2);
        LOGGER.info(singerService.findById(mockSinger1.getId()).toString());
        LOGGER.info(singerService.findById(mockSinger2.getId()).toString());
        assertEquals(5, singerService.findAll().size());
    }

    private Singer createMockSinger(String fname, String lname, Date dob) {
        Singer singer = createSingerWithBasicInfo(fname, lname, dob);
        addAlbumsTo(singer);
        addInstrumentsTo(singer);
        return singer;
    }

    private Singer createSingerWithBasicInfo(String fname, String lname, Date dob) {
        Singer singer = new Singer();
        singer.setFirstName(fname);
        singer.setLastName(lname);
        singer.setBirthDate(dob);
        return singer;
    }

    private void addAlbumsTo(Singer singer) {
        Album album = createAlbum("My Kind of Blues", generateDate(1961, 7, 18));
        singer.addAlbum(album);
        album = createAlbum("A Heart Full of Blues", generateDate(1962, 3, 20));
        singer.addAlbum(album);
    }

    private Date generateDate(int year, int month, int date) {
        return new Date(new GregorianCalendar(year, month, date)
            .getTimeInMillis());
    }

    private Album createAlbum(String name, Date releaseDate) {
        Album album = new Album();
        album.setTitle(name);
        album.setReleaseDate(releaseDate);
        return album;
    }

    private void addInstrumentsTo(Singer singer) {
        Instrument violin = getInstrument("Violin");
        Instrument cello = getInstrument("Cello");
        singer.setInstruments(Set.of(violin, cello));
    }

    private Instrument getInstrument(String name) {
        Instrument instrument = null;
        try {
            instrument = instrumentService.findByName(name);
        } catch (NoResultException e) {
            instrument = new Instrument();
            instrument.setName(name);
        }
        return instrument;
    }

    @Test
    public void testUpdate() {
        Singer singer = singerService.findById(1l);
        singer.setFirstName("John Clayton");
        Album album = singer.getAlbums().stream().filter(
            a -> a.getTitle().equals("Battle Studies")).findFirst().get();
        singer.removeAlbum(album);
        singerService.save(singer);
        
        singer = singerService.findById(1l);
        LOGGER.info(singer.toString());
        assertEquals("John Clayton", singer.getFirstName());
        assertFalse(singer.getAlbums().contains(album));
    }

    @Test(expected = NoResultException.class)
    public void testDelete() {
        Singer singer = singerService.findById(1l);
        singerService.delete(singer);
        singerService.findById(1l);
    }
}