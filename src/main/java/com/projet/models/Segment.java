package com.projet.models;

import java.util.Random;

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

    public Segment(Station depart, Station arrivee){
        this.depart = depart;
        this.arrivee = arrivee;
        Random rand = new Random();
        this.incident = (rand.nextInt(100) > 70);   // Probabilité d'incident : 70%
        this.tempsDeTrajet = calculerTempsTrajetInitial();
    }

    /* ------ Methodes publiques ------ */
    public int calculerTempsTrajet(){
        // TODO: Complete
        return 0;
    }

    /**
     * Calculer le temps de trajet de base hors l'effet d'incidents 
     * @return  temps de trajet entre la station de depart et la station d'arrivé TODO: Complete
     */
    public int calculerTempsTrajetInitial(){
        double distance = arrivee.calculerDistance(depart);     // On calcule la distance
        Random rand = new Random();
        // La vitess en unite de distance par unite de temps. comprise entre 10 et 20
        int vitess = rand.nextInt(11)+10 ;      
        return (int)distance/vitess;
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
