package com.example.helloworld.database.plainjdbc;

import java.util.List;

public interface SingerDao {
    List<Singer> findAll();
    List<Singer> findAllWithAlbums();
    Singer findById(Long id);
    void insert(Singer singer);
    void deleteById(Long singerId);
}