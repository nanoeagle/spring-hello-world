package com.example.springhelloworld.database.transaction.dao;

import java.util.*;

import javax.persistence.*;

import com.example.springhelloworld.database.transaction.entities.Singer;

import org.hibernate.cfg.NotYetImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;

// @Service("transactionalSingerService")
public class SingerServiceImpl implements SingerService {
    @Autowired
    private TransactionTemplate transactionTemplate;
    
    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public List<Singer> findAll() {
        return transactionTemplate.execute(transactionStatus -> 
            entityManager.createNamedQuery(Singer.FIND_ALL, Singer.class)
                .getResultList());
    }

    @Override
    public long countAll() {
        return transactionTemplate.execute(transactionStatus -> 
            entityManager.createNamedQuery(Singer.COUNT_ALL, Long.class)
                .getSingleResult());
    }

    @Override
    public Singer save(Singer singer) {
        throw new NotYetImplementedException();
    }
}