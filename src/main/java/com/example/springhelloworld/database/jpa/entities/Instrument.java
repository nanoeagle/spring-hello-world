package com.example.springhelloworld.database.jpa.entities;

import javax.persistence.*;

@Entity
@Table(name = "instrument")
public class Instrument extends AbstractEntity {
    @Column(name = "instrument_name")
    private String name;
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Instrument: " + name;
    }
}