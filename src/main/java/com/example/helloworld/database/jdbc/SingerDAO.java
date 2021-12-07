package com.example.helloworld.database.jdbc;

import java.util.Set;

public interface SingerDAO {
    Set<Singer> findAll();
    void insert(Singer singer);
    void delete(Long singerId);
}