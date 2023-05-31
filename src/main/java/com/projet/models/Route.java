package com.projet.models;

import java.util.List;

public class Route {
    private Station depart;
    private Station terminal;
    private List<Station> stations;

    /*------ Constructeurs ------ */
    public Route() {
    }
    public Route(Station depart, Station terminal, List<Station> stations) {
        this.depart = depart;
        this.terminal = terminal;
        this.stations = stations;
    }

    /* ------ Methods publiques ------ */
    int calculerTempsTrajet(){
        // TODO: Complete
        return 0;
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
    
    
}
