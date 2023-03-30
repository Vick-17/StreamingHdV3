package fr.afpa.model;


import java.util.List;

public class Utilisateur {

    private String nom;
    private String nCompte;
    private List<Film> playlist;
    private Famille familleUser;

    public Utilisateur(String nom, String nCompte,List<Film> playlist, Famille famille) {
        this.nom = nom;
        this.nCompte = nCompte;
        this.playlist = playlist;
        this.familleUser = famille;
    }

    public Famille getFamille() {
        return familleUser;
    }

    public void setFamille(Famille famille) {
        this.familleUser = famille;
    }

    public List<Film> getPlaylist() {
        return playlist;
    }

    public void setPlaylist(List<Film> playlist) {
        this.playlist = playlist;
    }

    public String getNom()
    {
        return nom;
    }

    public void setNom(String nom)
    {
        this.nom = nom;
    }

    public String getnCompte()
    {
        return nCompte;
    }

    public void setnCompte(String nCompte)
    {
        this.nCompte = nCompte;
    }

    public void addMovie(Film add){
        playlist.add(add);
    }
    public void removeMovie(Film delete){
        playlist.remove(delete);
    }


    /*playlist = new ArrayList<Film>();*/
}
