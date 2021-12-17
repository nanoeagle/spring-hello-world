package com.example.helloworld.database.jdbc;

import java.util.Set;

public interface SingerDao {
    Set<Singer> findAll();
    Singer findById(Long id);
    void insert(Singer singer);
    void delete(Long singerId);
}