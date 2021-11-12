package com.bootcamp.spotify.domain.model;

import lombok.*;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idArtist;
    private String name;
    private String genre;
    private String image;

}
