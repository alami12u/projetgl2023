package com.projet.models;

import java.util.List;

/**
 * Contient les differents filtres definit par l'utilisateur
 * Une instance de cette class est passé aux methods de la class `Metro` pour prendre en consideration
 * les spécification de l'utilisateur
 * les spécification de l'utilisateur sont récuperées à partir de la console
 */
public class Filtre {
    private boolean plusRapide;         /** Option : Choisir la route la plus rapide en terme de temps de trajet */ 
    private boolean moinDeChangements;  /** Option : Choisir La route avec la moidre de correspendance*/ 
    private List<Station> stations;     /** Option : List des stations specifiées par l'utilisateur */
    
    // Constructeurs
    public Filtre(boolean plusRapide, boolean moinDeChangements, List<Station> stations) {
        this.plusRapide = plusRapide;
        this.moinDeChangements = moinDeChangements;
        this.stations = stations;
    }
    public Filtre() {
    }

    // Getters / setters
    public boolean isPlusRapide() {
        return plusRapide;
    }
    public void setPlusRapide(boolean plusRapide) {
        this.plusRapide = plusRapide;
    }
    public boolean isMoinDeChangements() {
        return moinDeChangements;
    }
    public void setMoinDeChangements(boolean moinDeChangements) {
        this.moinDeChangements = moinDeChangements;
    }
    public List<Station> getStations() {
        return stations;
    }
    public void setStations(List<Station> stations) {
        this.stations = stations;
    }

    
}
