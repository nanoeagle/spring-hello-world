package com.example.springhelloworld.database.transaction.dao;

import java.util.List;

import com.example.springhelloworld.database.transaction.entities.Singer;

public interface SingerService {
    List<Singer> findAll();
    long countAll();
    Singer save(Singer singer);
}