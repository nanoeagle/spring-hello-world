package com.example.springhelloworld.database.jpa.springdata;

import java.util.*;

import com.example.springhelloworld.database.jpa.entities.Singer;

public interface SpringDataSingerService {
    List<Singer> findAll();
    Optional<Singer> findById(Long id);
    List<Singer> findByFirstName(String firstName);
    List<Singer> findByFirstNameAndLastName(String firstName, String lastName);
    Singer save(Singer singer);
}