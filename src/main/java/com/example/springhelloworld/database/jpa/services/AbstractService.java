package com.example.springhelloworld.database.jpa.services;

import javax.persistence.*;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public class AbstractService {
    @PersistenceContext
    EntityManager entityManager;
}