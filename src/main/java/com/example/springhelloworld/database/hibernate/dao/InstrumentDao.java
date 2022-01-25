package com.example.springhelloworld.database.hibernate.dao;

import com.example.springhelloworld.database.hibernate.entities.Instrument;

public interface InstrumentDao {
    Instrument findByName(String name); 
}