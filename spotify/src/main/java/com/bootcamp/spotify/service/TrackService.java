package com.bootcamp.spotify.service;


import com.bootcamp.spotify.controller.request.AlbumRequest;
import com.bootcamp.spotify.controller.request.TrackRequest;
import com.bootcamp.spotify.domain.model.Album;
import com.bootcamp.spotify.domain.model.Track;

import java.util.List;

public interface TrackService {


    Track getTrack(Long id);

    List<Track> getTracks();

    Track createTrack(TrackRequest request);

    Track editTrack(TrackRequest request, Long id);

    Track deleteTrack(Long id);
}
