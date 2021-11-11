package com.bootcamp.spotify.service.impl;

import com.bootcamp.spotify.controller.request.AlbumRequest;
import com.bootcamp.spotify.domain.mappers.AlbumMapper;
import com.bootcamp.spotify.domain.model.Album;
import com.bootcamp.spotify.domain.model.Artist;
import com.bootcamp.spotify.exeptions.SpotifyExistExeption;
import com.bootcamp.spotify.exeptions.SpotifyNotExistExeption;
import com.bootcamp.spotify.service.IAlbumService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class AlbumService implements IAlbumService {

    @Autowired
    private AlbumMapper albumMapper;
    @Qualifier("albums")
    @Autowired
    private List<Album> albums;

    @PostConstruct
    public void init() {
        albumMap = new HashMap<>();
        albums.stream().forEach(album -> {
            albumMap.put(album.getIdAlbum(), album);
        });
    }

    private Map<Long, Album> albumMap;

    @Override
    public Album getAlbum(Long idAlbum) {
        return albumMap.get(idAlbum);
    }

    @Override
    public List<Album> getAlbums() {
        return new ArrayList<>(albumMap.values());
    }

    @Override
    public Album createAlbum(AlbumRequest request) {
        Album album = albumMapper.apply(request);
        if (albumMap.get(request.getIdAlbum()) == null) {
            albumMap.put(request.getIdAlbum(), albumMapper.apply(request));
        } else {
            log.error("El album ya existe");
            throw new SpotifyExistExeption("El album ya existe");
        }
        return album;
    }

    @Override
    public Album editAlbum(AlbumRequest request, Long idAlbum) {
        Album album = null;
        if (albumMap.get(idAlbum) != null) {
            album = albumMapper.apply(request);
            albumMap.remove(request.getIdAlbum());
            albumMap.put(request.getIdAlbum(), album);
        } else {
            log.error("El album NO existe");
            throw new SpotifyNotExistExeption("El album NO existe");
        }
        return album;
    }

    @Override
    public Album deleteAlbum(Long idAlbum) {
        return albumMap.remove(idAlbum);
    }
}
