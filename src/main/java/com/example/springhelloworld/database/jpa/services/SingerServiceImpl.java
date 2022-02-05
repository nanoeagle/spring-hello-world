package com.example.springhelloworld.database.jpa.services;

import java.util.List;

import com.example.springhelloworld.database.jpa.entities.Singer;
import com.example.springhelloworld.database.jpa.pojos.SingerWithLatestAlbum;

import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.Transactional;

@Service("jpaSingerService")
@Repository
public class SingerServiceImpl extends AbstractService 
implements SingerService {
    @Override
    @Transactional(readOnly = true)
    public List<Singer> findAll() {
        return entityManager
            .createQuery("from Singer s", Singer.class).getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Singer> findAllWithAssociations() {
        return entityManager
            .createNamedQuery("Singer.findAllWithAssociation", Singer.class)
            .getResultList();
    }

    /* @Override
    @Transactional(readOnly = true)
    public List<Object[]> findAllWithLatestAlbum() {
        String query = "select s.id, s.firstName, s.lastName, a.title "
            + "from Singer s left join s.albums a "
            + "where a.releaseDate = (select max(a2.releaseDate) "
            + "from Album a2 where a2.singer.id = s.id)";
            return entityManager
                .createQuery(query, Object[].class).getResultList();
    } */

    @Override
    @Transactional(readOnly = true)
    public List<SingerWithLatestAlbum> findAllWithLatestAlbum() {
        String query = "select " 
            + "new com.example.springhelloworld.database.jpa.pojos.SingerWithLatestAlbum(" 
            + "s.id, s.firstName, s.lastName, a.title) "
            + "from Singer s left join s.albums a "
            + "where a.releaseDate = (select max(a2.releaseDate) "
            + "from Album a2 where a2.singer.id = s.id)";
            return entityManager
                .createQuery(query, SingerWithLatestAlbum.class).getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    @SuppressWarnings("unchecked")
    public List<Singer> findAllByNativeQuery() {
        return entityManager
            // .createNativeQuery("select * from singer", Singer.class)
            .createNativeQuery("select * from singer", "singerResult")
            .getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public Singer findById(Long id) {
        return entityManager
            .createNamedQuery("Singer.findById", Singer.class)
            .setParameter("id", id).getSingleResult();
    }

    @Override
    public Singer save(Singer singer) {
        if (singer.getId() == null) entityManager.persist(singer);
        else entityManager.merge(singer);
        return singer;
    }

    @Override
    public void delete(Singer singer) {
        Singer mergedSinger = entityManager.merge(singer);
        entityManager.remove(mergedSinger);
    }
}