package com.projet.models;

import java.util.ArrayList;
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
     * @param longitude    position (longitude)
     * @param latitude      position (Latitude)
     * @return              Station la plus proche aux cordonnées en parametres
     */
    public Station stationProche(int longitude, int latitude){
        Station proche = null;
        double minDistance = Double.MAX_VALUE;

    for (Station station : this.stations) {
        double distance = station.calculerDistance(longitude, latitude);
        if (distance < minDistance) {
            minDistance = distance;
            proche = station;
        }
    }

    return proche;
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
        // Validation des parametres
        if(depart==null || arrivé==null || filtre==null){return null;}

        Route meilleureRoute = null;
        for(Ligne ligne:lignes){
            // Verifier si'il n ya qu'une seule ligne
            if(ligne.getStations().contains(arrivé) && ligne.getStations().contains(depart)){
                // Calculer la meilleur route
                Route route = calculerRoute(ligne, depart, arrivé, filtre);
                // Verifier les filtres
                if(route!=null && route.estMeilleur(meilleureRoute, filtre)){meilleureRoute=route;}

            }
        }
        return meilleureRoute;
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

    /* ---- Methodes privees ---- */
    private Route calculerRoute(Ligne ligne, Station depart, Station arrivee, Filtre filtre){
        List<Station> stations = new ArrayList<>();
        List<Segment> segments = new ArrayList<>();
        int indexDepart = ligne.getStations().indexOf(depart);
        int indexArrivee = ligne.getStations().indexOf(arrivee);
        boolean enAvant = indexDepart <= indexArrivee ;

        if(enAvant){
            for(int i=indexDepart; i<=indexArrivee; i++){
                Station nextStation = ligne.getStations().get(i);
                stations.add(ligne.getStations().get(i));
                if(stations.size()>1){
                    segments.add(ligne.getSegment(nextStation, stations.get(stations.size()-2)));
                }
            }
        }else{
            for(int i=indexDepart; i>=indexArrivee; i++){
                Station nextStation = ligne.getStations().get(i);
                stations.add(ligne.getStations().get(i));
                segments.add(ligne.getSegment(nextStation, stations.get(stations.size()-2)));

            }
        }

        return new Route(depart, arrivee, stations, segments);
    }
}
