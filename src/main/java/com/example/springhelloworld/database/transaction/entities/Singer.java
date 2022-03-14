package com.example.springhelloworld.database.transaction.entities;

import java.util.*;

import javax.persistence.*;

@Entity
@Table(name = "singer")
@NamedQueries({
    @NamedQuery(name = Singer.FIND_ALL, 
        query = "select s from Singer s"),
    @NamedQuery(name = Singer.COUNT_ALL, 
        query = "select count(s) from Singer s")})
@SqlResultSetMapping(name = "singerResult", 
    entities = @EntityResult(entityClass = Singer.class))
public class Singer extends AbstractEntity {
    public static final String FIND_ALL = "Singer.findAll";
    public static final String COUNT_ALL = "Singer.countAll";
    
    @Column(name = "first_name")
    private String firstName;
    
    @Column(name = "last_name")
    private String lastName;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "birth_date")
    private Date birthDate;

    @OneToMany(mappedBy = "singer", cascade = CascadeType.ALL, 
        orphanRemoval = true)
    private Set<Album> albums;
    
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }
    
    public Date getBirthDate() {
        return birthDate;
    }

    public Set<Album> getAlbums() {
        return albums;
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
    
    public void removeAlbum(Album album) {
        albums.remove(album);
    }

    public String toSimpleString() {
        return "Singer - Id: " + id + ", First name: " + firstName
            + ", Last name: " + lastName + ", Birthday: " + birthDate 
            + "\n";
    }
    
    @Override
    public String toString() {
        String info = toSimpleString();
        if (albums != null)
            for (Album album : albums) info += "\t" + album.toString() + "\n";
        return info;
    }
}