package com.bootcamp.spotify.service.impl;

import com.bootcamp.spotify.controller.request.AlbumRequest;
import com.bootcamp.spotify.domain.mappers.AlbumMapper;
import com.bootcamp.spotify.domain.model.Album;
import com.bootcamp.spotify.exeptions.SpotifyExistExeption;
import com.bootcamp.spotify.exeptions.SpotifyNotExistExeption;
import com.bootcamp.spotify.repository.AlbumRepository;
import com.bootcamp.spotify.service.AlbumService;
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
public class AlbumServiceImpl implements AlbumService {

    @Autowired
    private AlbumMapper albumMapper;

    @Autowired
    private AlbumRepository albumRepository;

    @Qualifier("albums")
    @Autowired
    private List<Album> albums;

    @PostConstruct
    public void init() {
        albums.stream().forEach(album -> {
            albumRepository.save(album);
        });
    }

    @Override
    public Album getAlbum(Long idAlbum) {
        return albumRepository.findByIdAlbum(idAlbum);}

    @Override
    public List<Album> getAlbums() {
        return null;
    }

    @Override
    public Album createAlbum(AlbumRequest request) {
        Album album = albumMapper.apply(request);
        if (albumRepository.findByIdAlbum(request.getIdAlbum()) != null) {
            log.error("El album ya existe");
            throw new SpotifyExistExeption("El album ya existe");
        } else {
            albumRepository.save(albumMapper.apply(request));
        }
        return album;
    }

    @Override
    public Album editAlbum(AlbumRequest request, Long idAlbum) {
        Album album = null;
        if (albumRepository.findByIdAlbum(idAlbum) != null) {
            album = albumMapper.apply(request);
            albumRepository.save(album);
        } else {
            log.error("El album NO existe");
            throw new SpotifyNotExistExeption("El album NO existe");
        }
        return album;
    }

    @Override
    public Album deleteAlbum(Long idAlbum) {
        return albumRepository.deleteByIdAlbum(idAlbum);
    }


}
