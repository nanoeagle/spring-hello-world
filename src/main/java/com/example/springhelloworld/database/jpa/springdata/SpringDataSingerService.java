package com.example.springhelloworld.database.jpa.springdata;

import java.util.*;

import com.example.springhelloworld.database.jpa.entities.Singer;

public interface SpringDataSingerService {
    List<Singer> findAll();
    Singer findById(Long id);
    Singer findSingerByAuditRevisionNumber(Long id, int auditNum);
    List<Singer> findByFirstName(String firstName);
    List<Singer> findByFirstNameAndLastName(String firstName, String lastName);
    Singer save(Singer singer);
}