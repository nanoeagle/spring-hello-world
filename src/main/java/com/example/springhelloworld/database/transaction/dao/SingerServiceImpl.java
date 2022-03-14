package com.example.springhelloworld.database.transaction.dao;

import java.util.*;

import com.example.springhelloworld.database.transaction.entities.Singer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("transactionalSingerService")
// @Transactional
public class SingerServiceImpl implements SingerService {
    @Autowired
    private SingerRepository repository;
    
    @Override
    // @Transactional(readOnly = true)
    public List<Singer> findAll() {
        List<Singer> singers = new ArrayList<>();
        for (Singer singer : repository.findAll()) singers.add(singer);
        return singers;
    }

    @Override
    // @Transactional(propagation = Propagation.NEVER)
    public long countAll() {
        return repository.countAll();
    }
}