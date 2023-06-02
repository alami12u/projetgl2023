package com.projet.models;

import java.util.Random;

public class Station {
    private String nom;
    private int latitude;
    private int longitude;
    private int dureeArret;
    private boolean Incident;

    /* Constructeurs */
    public Station() {
    }
    public Station(String nom, int latitude, int longitude, int dureeArret, boolean incident) {
        this.nom = nom;
        this.latitude = latitude;
        this.longitude = longitude;
        this.dureeArret = dureeArret;
        Incident = incident;
    }

    /**
     * Constructeur d'une station
     * Ce constructeur est conçu pour charger une station à partir du fichier .txt des station qui ne contient quile nom, la longtitude et la latitude
     * Les autre atributs sont géneré d'une manière aleatoire
     * @param nom           Nom de la station
     * @param latitude      La latitude
     * @param longitude    La longitude
     */
    public Station(String nom, int longitude, int latitude){
        this.nom = nom;
        this.latitude = latitude;
        this.longitude = longitude;
        Random rand = new Random();
        this.dureeArret = rand.nextInt(4)+2;        //  2 <= DurreeArret <= 5
        this.Incident = (rand.nextInt(100) > 80);   //  20% Chance pour avoir un incident
    }

    /* ------- Methodes publiques -------- */
    /**
     * Calculer la distance entre cette station et la station passé en paramètre
     * @param station
     * @return  La distance entre cette station et la station en paramètre
     */
    public double calculerDistance(Station station){
        return this.calculerDistance(station.getLongitude(), station.getLatitude());
    }

    /**
     * Calculer la distance entre cette station et les cordonnée passée en parametre
     * La distance est calculé à l'aide de la nomre euclidienne
     * @param longitude
     * @param latitude
     * @return  la distance calculée
     */
    public double calculerDistance(int longitude, int latitude){
        return Math.sqrt(
            Math.pow(this.longitude - longitude, 2)+Math.pow(this.latitude-latitude, 2)
        );
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
    public int getLongitude() {
        return longitude;
    }
    public void setLongitude(int longitude) {
        this.longitude = longitude;
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



    /* ---- Redefinitions ----- */
    @Override
    public String toString(){
        return this.nom + " : " + this.latitude + " ; " + this.longitude + " | Arret : " + this.dureeArret + " | "  + (this.Incident ? "Incident " : "Pas d'incident");  
    }
}
