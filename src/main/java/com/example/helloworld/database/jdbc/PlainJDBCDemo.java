package com.example.helloworld.database.jdbc;

import java.sql.Date;
import java.util.*;

import org.slf4j.*;

public class PlainJDBCDemo {
	private static Logger logger = LoggerFactory.getLogger(PlainJDBCDemo.class);
	private SingerDAO singerDAO = new PlainSingerDAO();
	
	public static void main(String... args) {
		PlainJDBCDemo demo = new PlainJDBCDemo();

		logger.info("Listing initial singer data:");
		demo.listAllSingers();

		logger.info("-------------");
		logger.info("Insert a new singer");
		Singer newSinger = demo.insertNewSingerBy(demo.singerDAO);
		
		logger.info("Listing data after a new singer is created:");
		demo.listAllSingers();

		logger.info("-------------");
		logger.info("Deleting the previous created singer.");
		demo.singerDAO.delete(newSinger.getId());

		logger.info("Listing data after the new singer is deleted:");
		demo.listAllSingers();
	}
		
	private void listAllSingers() {
		for (Singer singer : singerDAO.findAll()) 
			logger.info(singer.toString());
	}

	private Singer insertNewSingerBy(SingerDAO singerDAO) {
		Singer singer = new Singer();
		singer.setFirstName("Ed");
		singer.setLastName("Sheeran");
		singer.setBirthDate(new Date(new GregorianCalendar(
			1991, Calendar.FEBRUARY, 17).getTimeInMillis()));
		singerDAO.insert(singer);
		return singer;
	}
}