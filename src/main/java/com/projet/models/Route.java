package com.projet.models;

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
    int calculerTempsTrajet(){
        int temps = 0;
        for(Station station : stations) temps+=station.getDureeArret();
        for(Segment segment:segments) temps+=segment.calculerTempsTrajet();
        return temps;
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
