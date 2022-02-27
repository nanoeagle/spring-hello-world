package com.example.springhelloworld.database.jpa.springdata.springboot;

import java.util.*;

import javax.annotation.PostConstruct;

import com.example.springhelloworld.database.jpa.entities.*;
import com.example.springhelloworld.database.jpa.springdata.SpringDataSingerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class DBInitializer {
    @Autowired
    private SpringDataSingerRepository singerRepository;

    @PostConstruct
    public void initDB() {
        Singer singer = new Singer();
        singer.setFirstName("John");
        singer.setLastName("Mayer");
        singer.setBirthDate(generateDate(1977, 9, 16));
        singer.setInstruments(createInstrumentSet());
        singer.setAlbums(createAlbumSet());
        singerRepository.save(singer);
    }

    private Set<Instrument> createInstrumentSet() {
        Instrument guitar = new Instrument();
        guitar.setName("Guitar");
        Instrument piano = new Instrument();
        piano.setName("Piano");
        return Set.of(guitar, piano);
    }

    private Set<Album> createAlbumSet() {
        Album album1 = new Album();
        album1.setTitle("The Search For Everything");
        album1.setReleaseDate(generateDate(2017, 0, 20));
        Album album2 = new Album();
        album2.setTitle("Battle Studies");
        album2.setReleaseDate(generateDate(2009, 10, 17));
        return Set.of(album1, album2);
    }

    private Date generateDate(int year, int month, int date) {
        return new Date(new GregorianCalendar(year, month, date)
            .getTimeInMillis());
    }
}