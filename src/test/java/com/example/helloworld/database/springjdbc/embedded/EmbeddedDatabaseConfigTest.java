package com.example.helloworld.database.springjdbc.embedded;

import static org.junit.Assert.assertTrue;

import com.example.helloworld.database.jdbc.*;

import org.junit.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

public class EmbeddedDatabaseConfigTest {
	private GenericApplicationContext context;
	private SingerDao singerDao;

	@Before
	public void init() {
		context = new AnnotationConfigApplicationContext(EmbeddedDatabaseConfig.class);
		singerDao = context.getBean("singerDao", SingerDao.class);
	}

	@After
	public void releaseContext() {
		context.close();
	}

	@Test
	public void testSingerDaoFindById() {
        Singer mockSinger = createMockSinger();
        Singer realSinger = singerDao.findById(1l);
        assertTrue(mockSinger.equals(realSinger));
	}

    private Singer createMockSinger() {
        Singer singer = new Singer();
        singer.setId(1l);
        singer.setFirstName("John");
        singer.setLastName("Mayer");
        return singer;
    }
}