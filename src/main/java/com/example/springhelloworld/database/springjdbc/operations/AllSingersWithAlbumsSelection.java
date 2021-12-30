package com.example.springhelloworld.database.springjdbc.operations;

import java.sql.*;
import java.util.*;
import java.util.stream.Collectors;

import javax.sql.DataSource;

import com.example.springhelloworld.database.plainjdbc.*;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.object.MappingSqlQuery;

public class AllSingersWithAlbumsSelection extends MappingSqlQuery<Singer> {
    private static final String SQL = "select s.id, s.first_name, s.last_name," 
        + " s.birth_date, a.id as album_id, a.title, a.release_date" 
        + " from singer s left join album a on s.id = a.singer_id";

    private Map<Long, Singer> singerMap;

    public AllSingersWithAlbumsSelection(DataSource dataSource) {
        super(dataSource, SQL);
        singerMap = new HashMap<>();
    }

    @Override
    protected Singer mapRow(ResultSet rs, int rowNum) throws SQLException {
        Singer singer = addNewSingerToMapIfNonExistentUsing(rs);
        addAlbumToSingerIfFound(rs, singer);
        return singer;
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

    @Override
    public List<Singer> execute() throws DataAccessException {
        return Set.copyOf(super.execute()).stream()
            .collect(Collectors.toList());
    }
}