package com.example.springhelloworld.database.jpa.springdata;

import java.util.List;

import com.example.springhelloworld.database.jpa.entities.Singer;

import org.springframework.data.repository.CrudRepository;

public interface SpringDataSingerRepository 
extends CrudRepository<Singer, Long> {
    List<Singer> findByFirstName(String firstName);
    List<Singer> findByFirstNameAndLastName(String firstName, String lastName);
}