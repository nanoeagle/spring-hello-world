package com.example.springhelloworld.database.plainjdbc;
import java.io.Serializable;
import java.sql.Date;
import java.util.*;

public class Singer implements Serializable {
	private Long id;
	private String firstName;
	private String lastName;
	private Date birthDate;
	private Set<Album> albums;
	
	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return this.id;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public boolean addAlbum(Album album) {
		if (albums == null) albums = new TreeSet<>();
		return albums.add(album);
	}

	public void setAlbums(Set<Album> albums) {
		this.albums = albums;
	}

	public Set<Album> getAlbums() {
		return albums;
	}

	@Override
	public int hashCode() {
		return id.intValue();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || getClass() != obj.getClass()) return false;
		Singer another = (Singer) obj;
		return id == another.id ? true : false;
	}

	@Override
	public String toString() {
		return "Singer - Id: " + id + ", First name: " + firstName
			+ ", Last name: " + lastName + ", Birthday: " + birthDate;
	}
}