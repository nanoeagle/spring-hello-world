package com.example.springhelloworld.database.jpa.springdata;

import java.util.*;

import com.example.springhelloworld.database.jpa.entities.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("springDataJpaAlbumService")
@Transactional
public class SpringDataAlbumServiceImpl implements SpringDataAlbumService {
    @Autowired
    private SpringDataAlbumRepository albumRepository;

    @Override
    public List<Album> findBySinger(Singer singer) {
        return albumRepository.findBySinger(singer);
    }

    @Override
    public List<Album> findByTitle(String title) {
        return albumRepository.findByTitle(title);
    }
}