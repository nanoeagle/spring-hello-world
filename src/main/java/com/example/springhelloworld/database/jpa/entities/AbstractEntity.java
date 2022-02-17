package com.example.springhelloworld.database.jpa.entities;

import javax.persistence.*;

@MappedSuperclass
public abstract class AbstractEntity extends AuditableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @Version
    @Column(name = "version")
    private int version;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}