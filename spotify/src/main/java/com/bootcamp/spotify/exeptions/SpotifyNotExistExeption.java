package com.bootcamp.spotify.exeptions;

public class SpotifyNotExistExeption extends RuntimeException{
    public SpotifyNotExistExeption(String message){
        super(message);
    }
}
