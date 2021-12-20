package com.example.helloworld.database.plainjdbc;

import java.util.List;

public interface SingerDao {
    List<Singer> findAll();
    Singer findById(Long id);
    void insert(Singer singer);
    void deleteById(Long singerId);
}