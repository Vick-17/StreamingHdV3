package fr.afpa.model;

import java.util.ArrayList;

public class Playlist {
    private ArrayList<Film> movie;
    private int userId;
    private int movieId;

    public Playlist(int userId, int movieId) {
        this.userId = userId;
        this.movieId = movieId;
    }

    public Playlist() {

    }

    public Playlist(int movieId) {

    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }
}
