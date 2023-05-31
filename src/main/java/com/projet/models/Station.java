package com.projet.models;

public class Station {
    private String nom;
    private int latitude;
    private int longtitude;
    private int dureeArret;
    private boolean Incident;

    /* Constructeurs */
    public Station() {
    }
    public Station(String nom, int latitude, int longtitude, int dureeArret, boolean incident) {
        this.nom = nom;
        this.latitude = latitude;
        this.longtitude = longtitude;
        this.dureeArret = dureeArret;
        Incident = incident;
    }

    /* Getters / Setters */
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public int getLatitude() {
        return latitude;
    }
    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }
    public int getLongtitude() {
        return longtitude;
    }
    public void setLongtitude(int longtitude) {
        this.longtitude = longtitude;
    }
    public int getDureeArret() {
        return dureeArret;
    }
    public void setDureeArret(int dureeArret) {
        this.dureeArret = dureeArret;
    }
    public boolean isIncident() {
        return Incident;
    }
    public void setIncident(boolean incident) {
        Incident = incident;
    }

    

    

}
