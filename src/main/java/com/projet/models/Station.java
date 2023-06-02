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


    /* ------- Methodes publiques -------- */
    /**
     * Calculer la distance entre cette station et la station passé en paramètre
     * @param station
     * @return  La distance entre cette station et la station en paramètre
     */
    public double calculerDistance(Station station){
        return this.calculerDistance(station.getLongtitude(), station.getLatitude());
    }

    /**
     * Calculer la distance entre cette station et les cordonnée passée en parametre
     * La distance est calculé à l'aide de la nomre euclidienne
     * @param longtitude
     * @param latitude
     * @return  la distance calculée
     */
    public double calculerDistance(int longtitude, int latitude){
        return Math.sqrt(
            Math.pow(this.longtitude - longtitude, 2)+Math.pow(this.latitude-latitude, 2)
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
