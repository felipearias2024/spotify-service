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
        return Arrays.asList(Album.builder().idAlbum(1).idArtist(1).name("Mylo Xyloto").build());
    }

    @Bean(name = "artists")
    public List<Artist> getArtists()
    {
        return Arrays.asList(Artist.builder().idArtist(1).name("Coldplay").genre("Rock").image("url").build());
    }

    @Bean(name = "tracks")
    public List<Track> getTracks(){
        return Arrays.asList(Track.builder().id(1).name("Paradise").idAlbum(1).idArtist(1).reproduction(100).duration(4).build());
    }
}
