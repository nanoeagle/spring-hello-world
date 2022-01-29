package com.example.springhelloworld.database.jpa.services;

import com.example.springhelloworld.database.jpa.entities.Instrument;

public interface InstrumentService {
    Instrument findByName(String name);
}