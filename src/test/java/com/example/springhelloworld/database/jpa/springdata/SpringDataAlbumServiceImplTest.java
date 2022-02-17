package com.example.springhelloworld.database.jpa.springdata;

import static org.junit.Assert.assertEquals;

import java.util.List;

import com.example.springhelloworld.database.jpa.JpaConfig;
import com.example.springhelloworld.database.jpa.entities.*;

import org.junit.*;
import org.slf4j.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

public class SpringDataAlbumServiceImplTest {
    private static final Logger LOGGER = 
        LoggerFactory.getLogger(SpringDataAlbumServiceImplTest.class);
    
    private GenericApplicationContext context;
    private SpringDataAlbumService albumService;
    private SpringDataSingerService singerService;

    @Before
    public void init() {
        context = new AnnotationConfigApplicationContext(JpaConfig.class);
        albumService = context.getBean("springDataJpaAlbumService", SpringDataAlbumService.class);
        singerService = context.getBean("springDataJpaSingerService", SpringDataSingerService.class);
    }
    
    @After
    public void releaseContext() {
        if (context != null) context.close();
    }
    
    @Test
    public void testFindBySinger() {
        Singer singer = 
            singerService.findByFirstNameAndLastName("John", "Mayer").get(0);
        List<Album> albums = albumService.findBySinger(singer);
        for (Album album : albums) LOGGER.info("\n\t" + album.toString());
        assertEquals(2, albums.size());
    }

    @Test
    public void testFindByTitle() {
        List<Album> albums = albumService.findByTitle("The");
        for (Album album : albums) LOGGER.info("\n\t" +
            album.toString() + "\n\tSinger: " + album.getSinger().getFullName());
        assertEquals(2, albums.size());
    }
}