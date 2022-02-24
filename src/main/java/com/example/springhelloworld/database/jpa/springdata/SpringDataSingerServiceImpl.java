package com.example.springhelloworld.database.jpa.springdata;

import java.util.*;

import javax.persistence.*;

import com.example.springhelloworld.database.jpa.entities.Singer;

import org.hibernate.envers.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("springDataJpaSingerService")
@Transactional
public class SpringDataSingerServiceImpl implements SpringDataSingerService {
    @Autowired
    private SpringDataSingerRepository singerRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional(readOnly = true)
    public List<Singer> findAll() {
        List<Singer> singers = new ArrayList<>();
        for (Singer singer : singerRepository.findAll()) singers.add(singer);
        return singers;
    }

    @Override
    public Singer findById(Long id) throws NoSuchElementException {
        return singerRepository.findById(id).get();
    }

    @Override
    public Singer findSingerByAuditRevisionNumber(Long id, int auditNum) {
        AuditReader auditReader = AuditReaderFactory.get(entityManager);
        return auditReader.find(Singer.class, id, auditNum);
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