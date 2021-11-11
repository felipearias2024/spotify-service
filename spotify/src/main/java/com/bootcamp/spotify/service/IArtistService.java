package com.bootcamp.spotify.service;

import com.bootcamp.spotify.controller.request.AlbumRequest;
import com.bootcamp.spotify.controller.request.ArtistRequest;
import com.bootcamp.spotify.domain.model.Album;
import com.bootcamp.spotify.domain.model.Artist;

import java.util.List;

public interface IArtistService {
    Artist getArtist(Long idArtist);

    List<Artist> getArtist();

    Artist createArtist(ArtistRequest request);

    Artist editArtist(ArtistRequest request, Long idArtist);

    Artist deleteArtist(Long idArtist);

}

