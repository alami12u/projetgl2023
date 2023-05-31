package com.projet.models;

import java.util.List;

/**
 * Class principale qui permet de comprende la structure du réseau et choisir la station la plus proche
 * permet aussi de déterminer la route convenable aux specification de l'utilisateur
 * Cette class est aussi responsable de l'initialisation du réseau à partir des donnée des stations et des lignes 
 */
public class Metro {
    private List<Station> stations;     /** Liste de toutes les stations du réseau */
    private List<Ligne> lignes;         /** Liste de toutes les lignes du réseau */

    /* ------ Constructeurs ------ */
    public Metro() {
    }
    public Metro(List<Station> stations, List<Ligne> lignes) {
        this.stations = stations;
        this.lignes = lignes;
    }

    /* ------ Methods publiques */

    /**
     * Retourn la station la plus proche aux cordonnées passées en parametres;
     * @param longtitude    position (longtitude)
     * @param latitude      position (Latitude)
     * @return              Station la plus proche aux cordonnées en parametres
     */
    public Station stationProche(int longtitude, int latitude){

        return null;
    }

    /**
     * Trouver la route convenable aux specifications 
     * @param depart    Station de départ
     * @param arrivé    Station d'arrivée
     * @param filtre    Filtre définit par l'utilisateur
     * @return          Route idéal selon le filtre
     * 
     * 
     * @see                 Metro#stationProche(int, int)
     */
    public Route trouverRoute(Station depart, Station arrivé, Filtre filtre){

        return null;
    }

    /* ------ Getters / Setters ------ */
    public List<Station> getStations() {
        return stations;
    }
    public void setStations(List<Station> stations) {
        this.stations = stations;
    }
    public List<Ligne> getLignes() {
        return lignes;
    }
    public void setLignes(List<Ligne> lignes) {
        this.lignes = lignes;
    }

    
    
}
