package com.example.springhelloworld.database.springjdbc.jdbctemplate;

import java.sql.*;
import java.util.*;

import com.example.springhelloworld.database.plainjdbc.*;

import org.springframework.jdbc.core.ResultSetExtractor;

public final class SingerWithAlbumsExtractor 
implements ResultSetExtractor<List<Singer>> {
    private Map<Long, Singer> singerMap;

    public SingerWithAlbumsExtractor() {
        singerMap = new HashMap<>();
    }

    @Override
    public List<Singer> extractData(ResultSet rs) throws SQLException {
        while (rs.next()) {
            Singer singer = addNewSingerToMapIfNonExistentUsing(rs);
            addAlbumToSingerIfFound(rs, singer);
        }
        return new ArrayList<>(singerMap.values());
    }

    private Singer addNewSingerToMapIfNonExistentUsing(ResultSet rs) 
    throws SQLException  {
        Long singerId = rs.getLong("id");
        Singer singer = singerMap.get(singerId);
        if (singer == null) {
            singer = createNewSingerUsing(rs);
            singerMap.put(singerId, singer);
        }
        return singer;
    }

    private Singer createNewSingerUsing(ResultSet rs) throws SQLException {
        Singer singer = new Singer();
        singer.setId(rs.getLong("id"));
        singer.setFirstName(rs.getString("first_name"));
        singer.setLastName(rs.getString("last_name"));
        singer.setBirthDate(rs.getDate("birth_date"));
        singer.setAlbums(new HashSet<>());
        return singer;
    }

    private void addAlbumToSingerIfFound(ResultSet rs, Singer singer) 
    throws SQLException {
        Long albumId = rs.getLong("album_id");
        if (albumId > 0) {
            Album album = new Album();
            album.setId(albumId);
            album.setSingerId(singer.getId());
            album.setTitle(rs.getString("title"));
            album.setReleaseDate(rs.getDate("release_date"));
            singer.addAlbum(album);
        }
    }
}