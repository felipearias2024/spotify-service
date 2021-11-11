package com.bootcamp.spotify.controller.request;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@Builder
public class TrackRequest {
    @NotNull(message = "El campo id no puede ser null.")
    private long id;
    @NotNull(message = "El campo name no puede ser null.")
    private String name;
    //@NotNull(message = "El campo id no puede ser null.")
    private long idArtist;
    //@NotNull(message = "El campo id no puede ser null.")
    private long idAlbum;
    @NotNull(message = "El campo reproduccion no puede ser null.")
    private int reproduction;
    @NotNull(message = "El campo duration no puede ser null.")
    private int duration;
}
