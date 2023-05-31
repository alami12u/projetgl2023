package com.projet.models;

public class Segment {
    private Station depart;
    private Station arrivee;
    private int tempsDeTrajet;
    private boolean incident;

    /* ------ Constructeurs ------ */
    public Segment() {
    }
    public Segment(Station depart, Station arrivee, int tempsDeTrajet, boolean enIncident) {
        this.depart = depart;
        this.arrivee = arrivee;
        this.tempsDeTrajet = tempsDeTrajet;
        this.incident = enIncident;
    }

    /* ------ Methodes publiques ------ */
    public int calculerTempsTrajet(){
        // TODO: Complete
        return 0;
    }

    /* ------ Getters/Setters ------ */
    public Station getDepart() {
        return depart;
    }
    public void setDepart(Station depart) {
        this.depart = depart;
    }
    public Station getArrivee() {
        return arrivee;
    }
    public void setArrivee(Station arrivee) {
        this.arrivee = arrivee;
    }
    public int getTempsDeTrajet() {
        return tempsDeTrajet;
    }
    public void setTempsDeTrajet(int tempsDeTrajet) {
        this.tempsDeTrajet = tempsDeTrajet;
    }
    public boolean isIncident() {
        return incident;
    }
    public void setIncident(boolean enIncident) {
        this.incident = enIncident;
    }
    
}
