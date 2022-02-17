package com.example.springhelloworld.database.jpa.springdata;

import java.util.List;

import com.example.springhelloworld.database.jpa.entities.*;

public interface SpringDataAlbumService {
    List<Album> findBySinger(Singer singer);
    List<Album> findByTitle(String title);
}