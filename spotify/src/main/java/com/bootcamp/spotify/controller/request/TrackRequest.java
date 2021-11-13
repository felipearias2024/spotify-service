package com.bootcamp.spotify.controller.request;

import com.bootcamp.spotify.domain.model.Album;
import com.bootcamp.spotify.domain.model.Artist;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@Builder
public class TrackRequest {
    private long idTrack;
    @NotNull(message = "El campo name no puede ser null.")
    private String name;
    //@NotNull(message = "El campo id no puede ser null.")
    private Album album;
    @NotNull(message = "El campo reproduccion no puede ser null.")
    private int reproduction;
    @NotNull(message = "El campo duration no puede ser null.")
    private int duration;
}
