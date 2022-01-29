package com.example.springhelloworld.database.jpa.services;

import java.util.List;

import com.example.springhelloworld.database.jpa.entities.Singer;
import com.example.springhelloworld.database.jpa.pojos.SingerWithLatestAlbum;

public interface SingerService {
    List<Singer> findAll();
    List<Singer> findAllWithAssociations();
    // List<Object[]> findAllWithLatestAlbum();
    List<SingerWithLatestAlbum> findAllWithLatestAlbum();
    List<Singer> findAllByNativeQuery();
    Singer findById(Long id);
    Singer save(Singer singer);
    void delete(Singer singer);
}