package com.example.springhelloworld.database.hibernate.dao;

import java.util.*;

import com.example.springhelloworld.database.hibernate.entities.Singer;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("singerDao")
public class HibernateSingerDao extends AbstractHibernateDao 
implements SingerDao {
    @Override
    @Transactional(readOnly = true)
    public List<Singer> findAll() {
        return sessionFactory.getCurrentSession()
            .createQuery("from Singer s", Singer.class).list();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Singer> findAllWithAssociations() {
        return sessionFactory.getCurrentSession()
            .createNamedQuery("Singer.findAllWithAssociation", Singer.class)
            .list();
    }

    @Override
    @Transactional(readOnly = true)
    public Singer findById(Long id) {
        return (Singer) sessionFactory.getCurrentSession()
            .createNamedQuery("Singer.findById", Singer.class)
            .setParameter("id", id).uniqueResult();
    }

    @Override
    public void save(Singer singer) {
        sessionFactory.getCurrentSession().saveOrUpdate(singer);
    }

    @Override
    public void delete(Singer singer) {
        sessionFactory.getCurrentSession().delete(singer);
    }
}