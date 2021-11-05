package com.bootcamp.spotify.domain.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Album {
    private long idAlbum;
    private long idArtist;
    private String name;

}
