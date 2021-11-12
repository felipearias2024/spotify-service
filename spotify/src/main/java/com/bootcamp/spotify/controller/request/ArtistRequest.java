package com.bootcamp.spotify.controller.request;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@Builder
public class ArtistRequest {
    private long idArtist;
    @NotNull(message = "El campo name no puede ser null.")
    private String name;
    @NotNull(message = "El campo genre no puede ser null.")
    private String genre;
    @NotNull(message = "El campo image no puede ser null.")
    private String image;
}