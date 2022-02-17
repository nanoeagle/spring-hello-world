package com.example.springhelloworld.database.jpa.springdata;

import java.util.List;

import com.example.springhelloworld.database.jpa.entities.*;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

interface SpringDataAlbumRepository extends JpaRepository<Album, Long> {
    List<Album> findBySinger(Singer singer);
    
    @Query("select a from Album a where a.title like %:title%")
    // @Param to indicate that t is title and it is not needed when the 
    // named parameter in the @Query and the parameter of the method are 
    // the same.
    List<Album> findByTitle(@Param("title") String t);
}