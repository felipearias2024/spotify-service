package com.bootcamp.spotify.domain.mappers;

import com.bootcamp.spotify.controller.request.AlbumRequest;
import com.bootcamp.spotify.domain.model.Album;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class AlbumMapper implements Function<AlbumRequest, Album>{
    @Override
    public Album apply(AlbumRequest albumRequest) {
        return Album.builder().idAlbum(albumRequest.getIdAlbum()).artist(albumRequest.getArtist()).name(albumRequest.getName()).build();
    }
}
