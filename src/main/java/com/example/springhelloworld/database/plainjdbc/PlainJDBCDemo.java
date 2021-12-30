package com.example.springhelloworld.database.plainjdbc;

import java.sql.Date;
import java.util.*;

import org.slf4j.*;

public class PlainJDBCDemo {
	private static final Logger LOGGER = 
		LoggerFactory.getLogger(PlainJDBCDemo.class);
	private SingerDao singerDao = new PlainSingerDao();
	
	public static void main(String... args) {
		PlainJDBCDemo demo = new PlainJDBCDemo();

		LOGGER.info("Listing initial singer data:");
		demo.listAllSingers();

		LOGGER.info("-------------\nListing the singer No. 1:");
		LOGGER.info(demo.singerDao.findById(1l).toString());

		LOGGER.info("-------------");
		LOGGER.info("Insert a new singer");
		Singer newSinger = demo.insertNewSingerBy(demo.singerDao);
		
		LOGGER.info("Listing data after a new singer is created:");
		demo.listAllSingers();

		LOGGER.info("-------------");
		LOGGER.info("Deleting the previous created singer.");
		demo.singerDao.deleteById(newSinger.getId());

		LOGGER.info("Listing data after the new singer is deleted:");
		demo.listAllSingers();
	}
		
	private void listAllSingers() {
		List<Singer> allSingers = singerDao.findAll();
		allSingers.sort(new SingerIDComparator());
		for (Singer singer : allSingers) LOGGER.info(singer.toString());
	}

	private Singer insertNewSingerBy(SingerDao singerDao) {
		Singer singer = new Singer();
		singer.setFirstName("Ed");
		singer.setLastName("Sheeran");
		singer.setBirthDate(new Date(new GregorianCalendar(
			1991, Calendar.FEBRUARY, 17).getTimeInMillis()));
		singerDao.insert(singer);
		return singer;
	}

	private class SingerIDComparator implements Comparator<Singer> {
		@Override
		public int compare(Singer s1, Singer s2) {
			return (int) (s1.getId() - s2.getId());
		}
	}
}