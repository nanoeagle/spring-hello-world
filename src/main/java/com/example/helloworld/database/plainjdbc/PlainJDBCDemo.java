package com.example.helloworld.database.plainjdbc;

import java.sql.Date;
import java.util.*;

import org.slf4j.*;

public class PlainJDBCDemo {
	private static Logger logger = LoggerFactory.getLogger(PlainJDBCDemo.class);
	private SingerDao singerDao = new PlainSingerDao();
	
	public static void main(String... args) {
		PlainJDBCDemo demo = new PlainJDBCDemo();

		logger.info("Listing initial singer data:");
		demo.listAllSingers();

		logger.info("-------------\nListing the singer No. 1:");
		logger.info(demo.singerDao.findById(1l).toString());

		logger.info("-------------");
		logger.info("Insert a new singer");
		Singer newSinger = demo.insertNewSingerBy(demo.singerDao);
		
		logger.info("Listing data after a new singer is created:");
		demo.listAllSingers();

		logger.info("-------------");
		logger.info("Deleting the previous created singer.");
		demo.singerDao.deleteById(newSinger.getId());

		logger.info("Listing data after the new singer is deleted:");
		demo.listAllSingers();
	}
		
	private void listAllSingers() {
		List<Singer> allSingers = singerDao.findAll();
		allSingers.sort(new SingerIDComparator());
		for (Singer singer : allSingers) logger.info(singer.toString());
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