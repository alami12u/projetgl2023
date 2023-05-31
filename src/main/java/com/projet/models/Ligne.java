package com.projet.models;

import java.util.List;


/**
 * Une ligne de metro contenant des information sur ses station et ses segments
 * Passé à la classe Metro pour définir le réseau du metro
 */
public class Ligne {
    private String nom;             /** Nom de la ligne, pour l'identification coté utilisateur et l'affichage */
    private List<Station> stations; /** Liste des stations de cette ligne */
    private List<Segment> segments; /** Liste de la suite de segments de cette ligne */

    // Constructeurs
    public Ligne() {
    }
    public Ligne(String nom, List<Station> stations, List<Segment> segments) {
        this.nom = nom;
        this.stations = stations;
        this.segments = segments;
    }

    /* Getters / Setters */
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public List<Station> getStations() {
        return stations;
    }
    public void setStations(List<Station> stations) {
        this.stations = stations;
    }
    public List<Segment> getSegments() {
        return segments;
    }
    public void setSegments(List<Segment> segments) {
        this.segments = segments;
    }

    
}
