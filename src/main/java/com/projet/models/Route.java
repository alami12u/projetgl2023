package com.projet.models;

import java.util.ArrayList;
import java.util.List;

public class Route {
    private Station depart;
    private Station terminal;
    private List<Station> stations;
    private List<Segment> segments;

    /*------ Constructeurs ------ */
    public Route() {
    }
    public Route(Station depart, Station terminal, List<Station> stations, List<Segment> segments) {
        this.segments = segments;
        this.depart = depart;
        this.terminal = terminal;
        this.stations = stations;
    }

    /* ------ Methods publiques ------ */
    /**
     * Calculer le temps de trajet en fonction de temps de trajet de chaque segment et durée
     * d'arret de chack station
     * @return
     */
    public int calculerTempsTrajet(){
        int temps = 0;
        for(Station station : stations) temps+=station.getDureeArret();
        for(Segment segment:segments) temps+=segment.calculerTempsTrajet();
        return temps;
    }

    /**
     *  Compare Cette route avec la route en parametre selon les filtres
     * @param route
     * @param filtre
     * @return  true si cette route est la meilleur
     */
    public boolean estMeilleur(Route route, Filtre filtre) {
        if(route==null){return true;}
        if(filtre.isPlusRapide() && route.calculerTempsTrajet()>this.calculerTempsTrajet()){
            return true;
        }
        if(filtre.isMoinDeChangements() && route.getSegments().size() < this.getSegments().size()){
            return true;
        }
        return false;
    }

    public Route ajouter(Route route) throws Exception {
        Route totalRoute;
    
        if (this.terminal.getNom().equalsIgnoreCase(route.depart.getNom())) {
            this.setTerminal(route.getTerminal());
            for (Station station : route.getStations().subList(1, route.getStations().size())) {
                this.ajouterStation(station, route);
            }
            totalRoute = this;
        } else if (this.depart.getNom().equalsIgnoreCase(route.terminal.getNom())) {
            Route newRoute = route.ajouter(this);
            this.stations = newRoute.getStations();
            this.depart = newRoute.getDepart();
            this.terminal = newRoute.getTerminal();
            this.segments = newRoute.getSegments();
            totalRoute = this;
        } else {
            throw new Exception("Les deux routes ne font pas une correspondance");
        }
    
        return totalRoute;
    }
    

    public void ajouterStation(Station station, Route route){
        this.stations.add(station);
        this.segments.add(route.getSegment(station, stations.get(stations.size()-2)));
    }

    private Segment getSegment(Station station, Station station2) {
        for(Segment segment : segments){
            if(segment.contient(station2) && segment.contient(station)) return segment;
        }
        return null;
    }
    /* ------ Getters / Setters ------- */
    public Station getDepart() {
        return depart;
    }
    public void setDepart(Station depart) {
        this.depart = depart;
    }
    public Station getTerminal() {
        return terminal;
    }
    public void setTerminal(Station terminal) {
        this.terminal = terminal;
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
