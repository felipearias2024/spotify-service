package com.bootcamp.spotify.configuration;

import com.bootcamp.spotify.domain.model.Album;
import com.bootcamp.spotify.domain.model.Artist;
import com.bootcamp.spotify.domain.model.Track;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class SpotifyConfiguration {

    @Bean(name = "albums")
    public List<Album> getAlbums(){
        return Arrays.asList(
                Album.builder().idAlbum(1).artist(Artist.builder().idArtist(1).name("Coldplay").genre("Rock").image("url").build()).name("Mylo Xyloto").build(),
                Album.builder().idAlbum(2).artist(Artist.builder().idArtist(2).name("Imagine Dragons").genre("Pop").image("url").build()).name("Night Visions").build()
                );
    }

    @Bean(name = "artists")
    public List<Artist> getArtists()
    {
        return Arrays.asList(
                Artist.builder().idArtist(1).name("Coldplay").genre("Rock").image("url").build(),
                Artist.builder().idArtist(2).name("Imagine Dragons").genre("Pop").image("url").build(),
                Artist.builder().idArtist(3).name("Michael Jackson").genre("Pop").image("url").build(),
                Artist.builder().idArtist(4).name("Travis Scott").genre("Rap").image("url").build(),
                Artist.builder().idArtist(5).name("Madonna").genre("Pop").image("url").build(),
                Artist.builder().idArtist(6).name("Dua Lipa").genre("Pop").image("url").build() );
    }

    @Bean(name = "tracks")
    public List<Track> getTracks(){
        return Arrays.asList(
                Track.builder().idTrack(1).name("Paradise").album(Album.builder().idAlbum(1).artist(Artist.builder().name("Coldplay").genre("Rock").image("url").build()).name("Mylo Xyloto").build()).reproduction(200).duration(4).build(),
                Track.builder().idTrack(2).name("Demons").album(Album.builder().idAlbum(2).artist(Artist.builder().name("Imagine Dragons").genre("Pop").image("url").build()).name("Night Visions").build()).reproduction(100).duration(5).build(),
                Track.builder().idTrack(3).name("Radioactive").album(Album.builder().idAlbum(2).artist(Artist.builder().name("Imagine Dragons").genre("Pop").image("url").build()).name("Night Visions").build()).reproduction(110).duration(3).build(),
                Track.builder().idTrack(4).name("On top of the world").album(Album.builder().idAlbum(2).artist(Artist.builder().name("Imagine Dragons").genre("Pop").image("url").build()).name("Night Visions").build()).reproduction(125).duration(3).build(),
                Track.builder().idTrack(5).name("Bleeding out").album(Album.builder().idAlbum(2).artist(Artist.builder().name("Imagine Dragons").genre("Pop").image("url").build()).name("Night Visions").build()).reproduction(140).duration(2).build(),
                Track.builder().idTrack(6).name("It's time").album(Album.builder().idAlbum(2).artist(Artist.builder().name("Imagine Dragons").genre("Pop").image("url").build()).name("Night Visions").build()).reproduction(150).duration(4).build(),
                Track.builder().idTrack(7).name("Hear me").album(Album.builder().idAlbum(2).artist(Artist.builder().name("Imagine Dragons").genre("Pop").image("url").build()).name("Night Visions").build()).reproduction(175).duration(6).build());
    }
}
