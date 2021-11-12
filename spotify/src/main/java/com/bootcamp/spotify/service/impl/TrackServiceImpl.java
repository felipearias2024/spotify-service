package com.bootcamp.spotify.service.impl;

import com.bootcamp.spotify.controller.request.TrackRequest;
import com.bootcamp.spotify.domain.mappers.TrackMapper;
import com.bootcamp.spotify.domain.model.Track;
import com.bootcamp.spotify.repository.TrackRepository;
import com.bootcamp.spotify.service.TrackService;
import com.bootcamp.spotify.exeptions.*;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class TrackServiceImpl implements TrackService {

    @Autowired
    private TrackMapper trackMapper;

    @Autowired
    private TrackRepository trackRepository;

    @Qualifier("tracks")
    @Autowired
    private List<Track> tracks;

    @PostConstruct
    public void init() {
        tracks.stream().forEach(track -> {
            trackRepository.save(track);
        });
    }

    @Override
    public Track getTrack(Long id) {
        return trackRepository.findByIdTrack(id);
    }

    @Override
    public List<Track> getTracks() {
        return trackRepository.findAll();
    }

    @Override
    public Track createTrack(TrackRequest request) {
        Track track = trackMapper.apply(request);
        if (trackRepository.findById(request.getIdTrack()) == null) {
            trackRepository.save(trackMapper.apply(request));
        } else {
            log.error("El track ya existe");
            throw new SpotifyExistExeption("El track ya existe");
        }
        return track;
    }

    @Override
    public Track editTrack(TrackRequest request, Long id) {
        Track track = null;
        if (trackRepository.findById(id) != null) {
            track = trackMapper.apply(request);
            trackRepository.save(track);
        } else {
            log.error("El track no existe");
            throw new SpotifyNotExistExeption("El track NO existe");
        }
        return track;
    }

    @Override
    public Track deleteTrack(Long id) {
        return trackRepository.deleteByidTrack(id);
    }

    public Track increaseReproduction(Long idTrack){
        return trackRepository.updateReproduction(idTrack);
    }

    public List<Track> getTopSongs(Long idArtist) {
        return trackRepository.getTopSongs(idArtist);
    }

    public  List<Track> topCancionesPopulares() {
        return trackRepository.cancionesPopulares();
    }
}
