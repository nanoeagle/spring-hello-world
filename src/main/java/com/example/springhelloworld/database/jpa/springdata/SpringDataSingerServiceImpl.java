package com.example.springhelloworld.database.jpa.springdata;

import java.util.*;

import com.example.springhelloworld.database.jpa.entities.Singer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("springDataJpaSingerService")
@Transactional
public class SpringDataSingerServiceImpl implements SpringDataSingerService {
    @Autowired
    private SpringDataSingerRepository singerRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Singer> findAll() {
        List<Singer> singers = new ArrayList<>();
        for (Singer singer : singerRepository.findAll()) singers.add(singer);
        return singers;
    }

    @Override
    public Optional<Singer> findById(Long id) {
        return singerRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Singer> findByFirstName(String firstName) {
        return singerRepository.findByFirstName(firstName);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Singer> findByFirstNameAndLastName(String firstName, String lastName) {
        return singerRepository.findByFirstNameAndLastName(firstName, lastName);
    }

    @Override
    public Singer save(Singer singer) {
        return singerRepository.save(singer);
    }
}