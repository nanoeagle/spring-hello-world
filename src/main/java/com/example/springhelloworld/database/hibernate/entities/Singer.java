package com.example.springhelloworld.database.hibernate.entities;

import static org.hibernate.annotations.CascadeType.*;

import java.util.*;

import javax.persistence.*;

import org.hibernate.annotations.Cascade;

// @Entity
@Table(name = "singer")
@NamedQueries({
    @NamedQuery(name = "Singer.findAllWithAssociation",
        query = "select distinct s from Singer s " +
            "left join fetch s.albums a " +
            "left join fetch s.instruments i"),
    @NamedQuery(name = "Singer.findById",
        query = "select distinct s from Singer s " +
            "left join fetch s.albums a " +
            "left join fetch s.instruments i where s.id = :id")})
public class Singer extends AbstractEntity {
    @Column(name = "first_name")
    private String firstName;
    
    @Column(name = "last_name")
    private String lastName;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "birth_date")
    private Date birthDate;
    
    @OneToMany(mappedBy = "singer", 
        cascade = CascadeType.ALL, 
        orphanRemoval = true)
    private Set<Album> albums;
    
    @ManyToMany
    @Cascade(SAVE_UPDATE)
    @JoinTable(name = "singer_instrument",
        joinColumns = @JoinColumn(name = "SINGER_ID"),
        inverseJoinColumns = @JoinColumn(name = "INSTRUMENT_ID"))
    private Set<Instrument> instruments;
    
    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }
    
    public Date getBirthDate() {
        return birthDate;
    }
    
    public Set<Album> getAlbums() {
        return albums;
    }
    
    public Set<Instrument> getInstruments() {
        return instruments;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public void setAlbums(Set<Album> albums) {
        this.albums = albums;
    }

    public boolean addAlbum(Album album) {
        album.setSinger(this);
        if (albums == null) albums = new HashSet<>();
        return albums.add(album);
    }

    public void setInstruments(Set<Instrument> instruments) {
        this.instruments = instruments;
    }
    
    public void removeAlbum(Album album) {
        albums.remove(album);
    }

    public String toSimpleString() {
        return "Singer - Id: " + id + ", First name: " + firstName
            + ", Last name: " + lastName + ", Birthday: " + birthDate + "\n";
    }
    
    @Override
    public String toString() {
        String info = toSimpleString();
        if (albums != null)
            for (Album album : albums) info += "\t" + album.toString() + "\n";
        if (instruments != null) 
            for (Instrument instrument : instruments) 
                info += "\t" + instrument.toString() + "\n";
        return info;
    }
}