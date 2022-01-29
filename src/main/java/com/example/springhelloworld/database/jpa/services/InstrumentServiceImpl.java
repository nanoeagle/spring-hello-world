package com.example.springhelloworld.database.jpa.services;

import com.example.springhelloworld.database.jpa.entities.Instrument;

import org.springframework.stereotype.*;

@Service("jpaInstrumentService")
@Repository
public class InstrumentServiceImpl extends AbstractService
implements InstrumentService {
    @Override
    public Instrument findByName(String name) {
        String query = "from Instrument i where i.name = :name";
        return entityManager.createQuery(query, Instrument.class)
            .setParameter("name", name).getSingleResult();
    }
}