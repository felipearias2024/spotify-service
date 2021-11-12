package com.bootcamp.spotify.domain.mappers;
import com.bootcamp.spotify.controller.request.TrackRequest;
import com.bootcamp.spotify.domain.model.Track;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class TrackMapper implements Function<TrackRequest, Track>{
    @Override
    public Track apply(TrackRequest trackRequest) {
        return Track.builder().idTrack(trackRequest.getIdTrack()).name(trackRequest.getName()).album(trackRequest.getAlbum()).reproduction(trackRequest.getReproduction()).duration(trackRequest.getDuration()).build();
    }
}
