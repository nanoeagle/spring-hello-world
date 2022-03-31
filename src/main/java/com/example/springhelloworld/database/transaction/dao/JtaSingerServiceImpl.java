package com.example.springhelloworld.database.transaction.dao;

import java.util.*;

import javax.persistence.*;

import com.example.springhelloworld.database.transaction.entities.Singer;

// import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("jtaSingerService")
@Transactional
public class JtaSingerServiceImpl implements SingerService {
    @PersistenceContext(unitName = "emfA")
    private EntityManager emfA;
    @PersistenceContext(unitName = "emfB")
    private EntityManager emfB;
    
    @Override
    @Transactional(readOnly = true)
    public List<Singer> findAll() {
        List<Singer> singersFromDbA = findAllSingersUsing(emfA);
        List<Singer> singersFromDbB = findAllSingersUsing(emfB);
        List<Singer> result = new ArrayList<>();
        result.addAll(singersFromDbA);
        result.addAll(singersFromDbB);
        return result;
    }

    private List<Singer> findAllSingersUsing(EntityManager emf) {
        return emf.createNamedQuery(Singer.FIND_ALL, Singer.class).getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public long countAll() {
        long countAllFromDbA = countAllSingersUsing(emfA);
        long countAllFromDbB = countAllSingersUsing(emfB);
        return countAllFromDbA + countAllFromDbB;
    }

    private long countAllSingersUsing(EntityManager emf) {
        return emf.createNamedQuery(Singer.COUNT_ALL, Long.class)
            .getSingleResult();
    }

    @Override
    public Singer save(Singer singer) {
        Singer replicatedSinger = new Singer();
        replicatedSinger.setFirstName(singer.getFirstName());
        replicatedSinger.setLastName(singer.getLastName());
        replicatedSinger.setBirthDate(singer.getBirthDate());
        if (singer.getId() == null) {
            emfA.persist(singer);
            // throw new JpaSystemException(new PersistenceException(
            //     "Simulation of something going wrong."));
            emfB.persist(replicatedSinger);
        } else {
            emfA.merge(singer);
            emfB.merge(singer);
        }
        return singer;
    }
}