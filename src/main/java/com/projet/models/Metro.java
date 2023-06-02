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

        List<Ligne> lignes = new ArrayList<>();

        Route meilleureRoute = null;
        for(Ligne ligne:this.lignes){
            // Verifier si'il n ya qu'une seule ligne
            if(ligne.contient(depart)){lignes.add(ligne);}
            if(ligne.contient(arrivé)){lignes.add(ligne);}

        }
        if(lignes.size()==1){
            // Calculer la meilleur route
            Route route = calculerRoute(lignes.get(0), depart, arrivé, filtre);
            // Verifier les filtres
            if(route!=null){
                meilleureRoute = route;
            }
        }else if(lignes.size()==2){
            Route route = calculerRoute(lignes, depart, arrivé, filtre);
            meilleureRoute = route;
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
            for(int i=indexDepart; i>=indexArrivee; i--){
                Station nextStation = ligne.getStations().get(i);
                stations.add(ligne.getStations().get(i));
                if(stations.size()>1){
                    segments.add(ligne.getSegment(nextStation, stations.get(stations.size()-2)));
                }

            }
        }

        return new Route(depart, arrivee, stations, segments);
    }

    private Route calculerRoute(List<Ligne> lignes, Station depart, Station arrivee, Filtre filtre){
        List<Station> correspendances = lignes.get(0).getCorrespendance(lignes.get(1));
        Route meilleurRoute = null;
        Ligne ligneDepart = null;
        Ligne ligneArrivee = null;
        if(lignes.get(0).contient(depart)){
            ligneDepart = lignes.get(0);
            ligneArrivee = lignes.get(1);
        }else{
            ligneDepart = lignes.get(1);
            ligneArrivee = lignes.get(0);
        }
        for(Station station : correspendances){
            Route routeDepuisDepart = calculerRoute(ligneDepart, depart, station, filtre);
            Route routeVersArrivee = calculerRoute(ligneArrivee, station, arrivee, filtre);
            Route route = null;
            try {
                route = routeDepuisDepart.ajouter(routeVersArrivee);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
            if(route.estMeilleur(meilleurRoute, filtre)){meilleurRoute=route;}

        }
        return meilleurRoute;
    }
}
