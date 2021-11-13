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
public class Track {
    @Id
    @GeneratedValue
    private long idTrack;
    private String name;
    @ManyToOne
    @JoinColumn(name="idAlbum")
    private Album album;
    private int reproduction;
    @Column(name = "duration")
    private int duration;
}
