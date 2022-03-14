package com.example.springhelloworld.database.transaction.dao;

import com.example.springhelloworld.database.transaction.entities.Singer;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface SingerRepository extends CrudRepository<Singer, Long> {
    @Query("select count(s) from Singer s")
    long countAll();
}