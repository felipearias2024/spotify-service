package com.bootcamp.spotify.service.impl;

import com.bootcamp.spotify.controller.request.ArtistRequest;
import com.bootcamp.spotify.domain.mappers.AlbumMapper;
import com.bootcamp.spotify.domain.mappers.ArtistMapper;
import com.bootcamp.spotify.domain.model.Album;
import com.bootcamp.spotify.domain.model.Artist;
import com.bootcamp.spotify.exeptions.SpotifyExistExeption;
import com.bootcamp.spotify.exeptions.SpotifyNotExistExeption;
import com.bootcamp.spotify.service.IArtistService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;

@Slf4j
@Service
public class ArtistService implements IArtistService {

    @Autowired
    private ArtistMapper artistMapper;
    @Qualifier("artists")
    @Autowired
    private List<Artist> artists;

    @PostConstruct
    public void init(){
        artistMap = new HashMap<>();
        artists.stream().forEach(artist -> {
            artistMap.put(artist.getIdArtist(), artist);
        });
    }

    private Map<Long, Artist> artistMap;

    @Override
    public Artist getArtist(Long idArtist) {
        return artistMap.get(idArtist);
    }

    @Override
    public List<Artist> getArtist() {
        return new ArrayList<>(artistMap.values());
    }

    @Override
    public Artist createArtist(ArtistRequest request) {
        Artist artist = artistMapper.apply(request);
        if (artistMap.get(request.getIdArtist()) == null) {
            artistMap.put(request.getIdArtist(), artistMapper.apply(request));
        } else {
            log.error("El artista ya existe");
            throw new SpotifyExistExeption("El artista ya existe");
        }
        return artist;
    }

    @Override
    public Artist editArtist(ArtistRequest request, Long idArtist) {
        Artist artist = null;
        if (artistMap.get(idArtist) != null) {
            artist = artistMapper.apply(request);
            artistMap.remove(request.getIdArtist());
            artistMap.put(request.getIdArtist(), artist);
        } else {
            log.error("El artista NO existe");
            throw new SpotifyNotExistExeption("El artista NO existe");
        }
        return artist;
    }

    @Override
    public Artist deleteArtist(Long idArtist) {
        return artistMap.remove(idArtist);
    }
}
