package com.bootcamp.spotify.controller;

import com.bootcamp.spotify.controller.request.AlbumRequest;
import com.bootcamp.spotify.controller.request.ArtistRequest;
import com.bootcamp.spotify.controller.request.TrackRequest;
import com.bootcamp.spotify.domain.model.Album;
import com.bootcamp.spotify.domain.model.Artist;
import com.bootcamp.spotify.domain.model.Track;
import com.bootcamp.spotify.service.IAlbumService;
import com.bootcamp.spotify.service.IArtistService;
import com.bootcamp.spotify.service.ITrackService;
import com.bootcamp.spotify.service.impl.AlbumService;
import com.bootcamp.spotify.service.impl.ArtistService;
import com.bootcamp.spotify.service.impl.TrackService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/spotify")

public class SpotifyController {

    @Autowired
    private ArtistService artistService;
    @Autowired
    private AlbumService albumService;
    @Autowired
    private TrackService trackService;

    @PostMapping(path = "/album")
    public Album createAlbum(@RequestBody AlbumRequest request){
        return albumService.createAlbum(request);
    }

    @GetMapping(path = "/album")
    public List<Album> retriveAlbums(){
        return albumService.getAlbums();
    }

    @GetMapping(path = "/album/{idAlbum}")
    public Album retriveAlbum(@PathVariable("idAlbum") Long id) {
        return albumService.getAlbum(id);
    }

    @PutMapping(path = "/album/{idAlbum}")
    public Album editAlbum(@Validated @RequestBody AlbumRequest request, @PathVariable("idAlbum") Long idAlbum) {
        return albumService.editAlbum(request, idAlbum);
    }

    @DeleteMapping(path = "/album/{idAlbum}")
    public Album deleteAlbum(@PathVariable("idAlbum") Long id) {
        return albumService.deleteAlbum(id);
    }

    @PostMapping(path = "/artist")
    public Artist createArtist(@RequestBody ArtistRequest request){
        return artistService.createArtist(request);
    }

    @GetMapping(path = "/artist")
    public List<Artist> retriveArtist(){
        return artistService.getArtist();
    }

    @GetMapping(path = "/artist/{idArtist}")
    public Artist retriveArtist(@PathVariable("idArtist") Long id) {
        return artistService.getArtist(id);
    }

    @PutMapping(path = "/artist/{idArtist}")
    public Artist editArtist(@Validated @RequestBody ArtistRequest request, @PathVariable("idArtist") Long id) {
        return artistService.editArtist(request, id);
    }

    @DeleteMapping(path = "/artist/{idArtist}")
    public Artist deleteArtist(@PathVariable("idArtist") Long id) {
        return artistService.deleteArtist(id);
    }


    @PostMapping(path = "/track")
    public Track createTrack(@RequestBody TrackRequest request){return trackService.createTrack(request);}

    @GetMapping(path = "/track")
    public List<Track> retriveTrack(){
        return trackService.getTracks();
    }

    @GetMapping(path = "/track/{id}")
    public Track retriveTrack(@PathVariable("id") Long id) {
        return trackService.getTrack(id);
    }

    @PutMapping(path = "/track/{id}")
    public Track editTrack(@Validated @RequestBody TrackRequest request, @PathVariable("id") Long id) {
        return trackService.editTrack(request, id);
    }

    @DeleteMapping(path = "/track/{id}")
    public Track deleteTrack(@PathVariable("id") Long id) {
        return trackService.deleteTrack(id);
    }

    @GetMapping(path = "/play/track/{id}")
    public Track play(@PathVariable("id") Long id) {
        return trackService.increaseReproducton(id);
    }




}
