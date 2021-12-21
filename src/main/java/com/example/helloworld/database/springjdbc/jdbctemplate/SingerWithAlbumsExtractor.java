package com.example.helloworld.database.springjdbc.jdbctemplate;

import com.example.helloworld.database.plainjdbc.*;

import java.sql.*;
import java.util.*;

import org.springframework.jdbc.core.ResultSetExtractor;

public final class SingerWithAlbumsExtractor 
implements ResultSetExtractor<List<Singer>> {
    private Map<Long, Singer> singerMap = new HashMap<>();
    private Singer singer;

    @Override
    public List<Singer> extractData(ResultSet rs) throws SQLException {
        while (rs.next()) {
            addNewSingerToMapIfNonExistentUsing(rs);
            addAlbumToSingerIfFoundUsing(rs);
        }
        return new ArrayList<>(singerMap.values());
    }

    private void addNewSingerToMapIfNonExistentUsing(ResultSet rs) 
    throws SQLException  {
        Long singerId = rs.getLong("id");
        singer = singerMap.get(singerId);
        if (singer == null) {
            singer = createNewSingerUsing(rs);
            singerMap.put(singerId, singer);
        }
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

    private void addAlbumToSingerIfFoundUsing(ResultSet rs) 
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