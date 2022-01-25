package com.example.springhelloworld.database.hibernate.entities;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "album")
public class Album extends AbstractEntity implements Comparable<Album> {
    @Column(name = "title")
    private String title;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "release_date")
    private Date releaseDate;
    
    @ManyToOne
    @JoinColumn(name = "singer_id")
    private Singer singer;

    public String getTitle() {
        return this.title;
    }
    
    public Date getReleaseDate() {
        return this.releaseDate;
    }
    
    public Singer getSinger() {
        return singer;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setSinger(Singer singer) {
        this.singer = singer;
    }

    @Override
    public String toString() {
        return "Album - Id: " + id + ", Title: " + title 
            + ", Release Date: " + releaseDate;
    }

    @Override
    public int compareTo(Album another) {
        return releaseDate.compareTo(another.releaseDate);
    }
}