package com.bootcamp.spotify.service;

import com.bootcamp.spotify.controller.request.AlbumRequest;
import com.bootcamp.spotify.controller.request.ArtistRequest;
import com.bootcamp.spotify.domain.model.Album;
import com.bootcamp.spotify.domain.model.Artist;

import java.util.List;
public interface AlbumService {

    Album getAlbum(Long idAlbum);

    List<Album> getAlbums();

    Album createAlbum(AlbumRequest request);

    Album editAlbum(AlbumRequest request, Long idAlbum);

    Album deleteAlbum(Long idAlbum);
}
