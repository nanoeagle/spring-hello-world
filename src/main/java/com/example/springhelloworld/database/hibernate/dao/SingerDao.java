package com.example.springhelloworld.database.hibernate.dao;

import java.util.List;

import com.example.springhelloworld.database.hibernate.entities.Singer;

public interface SingerDao {
    List<Singer> findAll();
    List<Singer> findAllWithAssociations();
    Singer findById(Long id);
    void save(Singer singer);
    void delete(Singer singer);
}