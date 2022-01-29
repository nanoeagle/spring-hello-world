package com.example.springhelloworld.database.jpa.pojos;

import java.io.Serializable;

public class SingerWithLatestAlbum implements Serializable {
    private Long id;
    private String firstName;
    private String lastName;
    private String latestAlbum;
    
    public SingerWithLatestAlbum(Long id, String firstName, 
        String lastName,String latestAlbum) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.latestAlbum = latestAlbum;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getLatestAlbum() {
        return latestAlbum;
    }

    @Override
    public String toString() {
        return "Singer ID - " + id + ": " + firstName + " " 
            + lastName + ", most recent album: " + latestAlbum;
    }
}