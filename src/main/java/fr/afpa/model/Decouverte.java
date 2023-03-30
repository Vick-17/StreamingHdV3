package fr.afpa.model;

public class Decouverte extends Compte {

    private int playlist;
    private boolean filmRegarde;

    public Decouverte(int playlist, boolean filmRegarde) {
        super();
        this.playlist = playlist;
        this.filmRegarde = filmRegarde;
    }

    public int getPlaylist() {
        return playlist;
    }

    public void setPlaylist(int playlist) {
        this.playlist = playlist;
    }

    public boolean isFilmRegarde() {
        return filmRegarde;
    }

    public void setFilmRegarde(boolean filmRegarde) {
        this.filmRegarde = filmRegarde;
    }

}
