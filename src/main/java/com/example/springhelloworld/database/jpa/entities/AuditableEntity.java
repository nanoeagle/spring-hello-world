package com.example.springhelloworld.database.jpa.entities;

import java.io.Serializable;
import java.util.*;

import javax.persistence.*;

import org.springframework.data.annotation.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AuditableEntity implements Serializable {
    @CreatedBy
    @Column(name = "created_by")
    String createdBy;

    @CreatedDate
    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    Date createdDate;
    
    @LastModifiedBy
    @Column(name = "last_modified_by")
    String lastModifiedBy;
    
    @LastModifiedDate
    @Column(name = "last_modified_date")
    @Temporal(TemporalType.TIMESTAMP)
    Date lastModifiedDate;

    public Optional<String> getCreatedBy() {
        return Optional.of(createdBy);
    }

    public Optional<Date> getCreatedDate() {
        return Optional.of(createdDate);
    }

    public Optional<String> getLastModifiedBy() {
        return Optional.of(lastModifiedBy);
    }

    public Optional<Date> getLastModifiedDate() {
        return Optional.of(lastModifiedDate);
    }
    
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }
}