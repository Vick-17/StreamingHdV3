package fr.afpa.model;

import java.sql.Date;
import java.util.List;

public class Film {

    private String titre;
    private Date dateSortie;
    private int id;
    private String imgPath;
    private List<Acteur> listActeur;
    
    public Film(String titre) {
        this.titre = titre;
    }

    public Film(String titre, Date dateSortie, int id, String imgPath) {
        this.titre = titre;
        this.dateSortie = dateSortie;
        this.id = id;
        this.imgPath = imgPath;
    }

    public Film(String titre, Date dateSortie, int id, List<Acteur> listActeur) {
        this.titre = titre;
        this.dateSortie = dateSortie;
        this.listActeur = listActeur;
        this.id = id;
    }

    public Film() {

    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Date getDateSortie() {
        return dateSortie;
    }

    public void setDateSortie(Date dateSortie) {
        this.dateSortie = dateSortie;
    }

    public List<Acteur> getListActeur() {
        return listActeur;
    }

    public void setListActeur(List<Acteur> listActeur) {
        this.listActeur = listActeur;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
