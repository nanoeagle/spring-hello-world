package com.example.springhelloworld.database.springjdbc.jdbctemplate;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.sql.Date;
import java.util.*;
import java.util.function.Function;
import java.util.stream.*;

import com.example.springhelloworld.database.plainjdbc.*;

import org.junit.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

public class JdbcTemplateSingerDaoTest {
    protected GenericApplicationContext context;
    protected SingerDao singerDao;

    @Before
    public void init() {
        context = new AnnotationConfigApplicationContext(
            JdbcTemplateDatabaseConfig.class);
        singerDao = context.getBean("singerDao", SingerDao.class);
    }

    @After
    public void releaseContext() {
        context.close();
    }
    
    @Test
    public void testFindAll() {
        List<Singer> allExpectedSingers = createExpectedSingers();
        List<Singer> allFoundSingers = singerDao.findAll();
        assertThat(allFoundSingers, equalTo(allExpectedSingers));
    }
    
    private List<Singer> createExpectedSingers() {
        String[][] allSingersInfo = {
            {"1", "John", "Mayer", "1977-10-16"},
            {"2", "Eric", "Clapton", "1945-03-30"},
            {"3", "John", "Butler", "1975-04-01"}};
        return Arrays.stream(allSingersInfo)
            .map(new InfoToSingerMapper()).collect(Collectors.toList());
    }

    @Test
    public void testFindAllWithAlbums() {
        List<Singer> allFoundSingers = singerDao.findAllWithAlbums();
        allFoundSingers.forEach(singer -> {
            System.out.println(singer);
            if (singer.getAlbums() != null) singer.getAlbums()
                .forEach(album -> System.out.println("\t" + album));
        });
        assertTrue(allFoundSingers.size() == 3);
    }

    @Test
    public void testFindById() {
        Singer expectedSinger = 
            createExpectedSinger("1", "John", "Mayer", "1977-10-16");
        Singer foundSinger = singerDao.findById(expectedSinger.getId());
        assertThat(foundSinger, equalTo(expectedSinger));
    }

    protected Singer createExpectedSinger(String... info) {
        String[][] singerInfo = {{info[0], info[1], info[2], info[3]}};
        return Stream.of(singerInfo)
            .map(new InfoToSingerMapper()).findFirst().get();
    }

    @Test
    public void testDeleteById() {
        Singer deletedSinger = 
            createExpectedSinger("1", "John", "Mayer", "1977-10-16");
        singerDao.deleteById(deletedSinger.getId());
        Singer nonexistentSinger = singerDao.findById(deletedSinger.getId());
        assertNull(nonexistentSinger);
    }

    @Test
    public void testInsert() {
        Singer insertedSinger = 
            createExpectedSinger("4", "Ed", "Sheeran", "1991-2-17");
        Singer nonexistentSinger = singerDao.findById(insertedSinger.getId());
        assertNull(nonexistentSinger);
        
        singerDao.insert(insertedSinger);
        Singer existingSinger = singerDao.findById(insertedSinger.getId());
        assertThat(existingSinger, equalTo(insertedSinger));
    }

    private class InfoToSingerMapper implements Function<String[], Singer> {
        @Override
        public Singer apply(String[] singerInfo) {
            Singer singer = new Singer();
            singer.setId(Long.parseLong(singerInfo[0]));
            singer.setFirstName(singerInfo[1]);
            singer.setLastName(singerInfo[2]);
            singer.setBirthDate(parseStringAsDate(singerInfo[3]));
            return singer;
        }

        private Date parseStringAsDate(String string) {
            int[] dateInfo = Arrays.stream(string.split("-"))
                .mapToInt(Integer::parseInt).toArray();
            return new Date(new GregorianCalendar(dateInfo[0], dateInfo[1] - 1, 
                dateInfo[2]).getTimeInMillis());
        }
    }
}