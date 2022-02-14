package com.example.springhelloworld.database.jpa.services;

import java.util.*;

import com.example.springhelloworld.database.jpa.entities.Singer;
import com.example.springhelloworld.database.jpa.pojos.SingerWithLatestAlbum;

public interface SingerService {
    List<Singer> findAll();
    List<Singer> findAllWithAssociations();
    // List<Object[]> findAllWithLatestAlbum();
    List<SingerWithLatestAlbum> findAllWithLatestAlbum();
    List<Singer> findAllByNativeQuery();
    List<Singer> findByFields(Map<String, ?> fields);
    Singer findById(Long id);
    Singer save(Singer singer);
    void delete(Singer singer);
}