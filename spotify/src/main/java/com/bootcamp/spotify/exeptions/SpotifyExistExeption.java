package com.bootcamp.spotify.exeptions;

public class SpotifyExistExeption extends RuntimeException{
    public SpotifyExistExeption(String message){
        super(message);
    }
}
