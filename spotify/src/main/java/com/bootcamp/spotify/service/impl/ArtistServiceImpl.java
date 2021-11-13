package com.bootcamp.spotify.service.impl;

import com.bootcamp.spotify.controller.request.ArtistRequest;
import com.bootcamp.spotify.domain.mappers.ArtistMapper;
import com.bootcamp.spotify.domain.model.Album;
import com.bootcamp.spotify.domain.model.Artist;
import com.bootcamp.spotify.domain.model.Track;
import com.bootcamp.spotify.exeptions.SpotifyExistExeption;
import com.bootcamp.spotify.exeptions.SpotifyNotExistExeption;
import com.bootcamp.spotify.repository.ArtistRepository;
import com.bootcamp.spotify.service.ArtistService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;

@Slf4j
@Service
public class ArtistServiceImpl implements ArtistService {
    @Autowired
    private ArtistMapper artistMapper;
    @Qualifier("artists")
    @Autowired
    private List<Artist> artists;
    @Autowired
    private ArtistRepository artistRepository;

    @PostConstruct
    public void init() {
        artists.stream().forEach(Artist -> {

            artistRepository.save(Artist);
        });
    }

    @Override
    public Artist getArtist(Long idArtist) {
        return artistRepository.findByIdArtist(idArtist);
    }

    @Override
    public List<Artist> getArtist() {
        return null;
    }

    @Override
    public Artist createArtist(ArtistRequest request) {
        Artist artist = artistMapper.apply(request);
        if (artistRepository.findByIdArtist(request.getIdArtist()) != null) {
            log.error("El artista ya existe");
            throw new SpotifyExistExeption("El artista ya existe");
        } else {
            artistRepository.save(artistMapper.apply(request));
        }
        return artist;
    }

    @Override
    public Artist editArtist(ArtistRequest request, Long idArtist) {
        Artist artist = null;
        if (artistRepository.findByIdArtist(idArtist) != null) {
            artist = artistMapper.apply(request);
            artistRepository.save(artist);
        } else {
            log.error("El artista NO existe");
            throw new SpotifyNotExistExeption("El artista NO existe");
        }
        return artist;
    }

    @Override
    public Artist deleteArtist(Long idArtist) {
        return artistRepository.deleteByIdArtist(idArtist);
    }

    public List<Artist> getTopArtistas() {
        return artistRepository.topArtistas();
    }

}

