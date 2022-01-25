package com.example.springhelloworld.database.hibernate.dao;

import com.example.springhelloworld.database.hibernate.entities.Instrument;

import org.springframework.stereotype.Repository;

@Repository("instrumentDao")
public class HibernateInstrumentDao extends AbstractHibernateDao 
implements InstrumentDao {
    @Override
    public Instrument findByName(String name) {
        return (Instrument) sessionFactory.getCurrentSession()
            .createQuery("from Instrument i where i.name = :name")
            .setParameter("name", name).uniqueResult();
    }
}