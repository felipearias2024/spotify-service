package com.bootcamp.spotify.domain.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idAlbum;
    @ManyToOne
    @JoinColumn(name="idArtist")
    private Artist artist;
    private String name;

}
