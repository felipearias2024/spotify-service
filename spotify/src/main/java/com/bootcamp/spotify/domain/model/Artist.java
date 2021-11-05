package com.bootcamp.spotify.domain.model;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Artist {

    private long idArtist;
    private String name;
    private String genre;
    private String image;

}
