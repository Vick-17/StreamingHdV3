package fr.afpa.model;

import java.util.List;

public class Famille {

    private List<Utilisateur> membre;
    private int reduction;

    public Famille(List<Utilisateur> membre, int reduction) {
        this.membre = membre;
        this.reduction = reduction;
    }

    public List<Utilisateur> getMembre() {
        return membre;
    }

    public void setMembre(List<Utilisateur> membre) {
        this.membre = membre;
    }

    public int getReduction() {
        return reduction;
    }

    public void setReduction(int reduction) {
        this.reduction = reduction;
    }

    public void addMembre(Utilisateur add){
        membre.add(add);
    }
    public void removeMembre(Utilisateur remove){
        membre.remove(remove);
    }
}
