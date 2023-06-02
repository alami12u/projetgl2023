package com.projet;

import com.projet.initialisation.InitMetro;
import com.projet.models.Filtre;
import com.projet.models.Metro;
import com.projet.models.Route;
import com.projet.models.Station;

public class App 
{
    private static InitMetro initMetro = new InitMetro();
    public static void main( String[] args )
    {
        Metro metro = initMetro.init("data/Stations.txt", "data/Lignes.txt"); 
        Station station1 = initMetro.stationParNom(metro.getStations(), "Ternes");
        Station station2 = initMetro.stationParNom(metro.getStations(), "Jaurés");
        Route route = metro.trouverRoute(station1, station2, new Filtre(false, true, null));
        System.out.println("----------  la meilleur route : ");
        for(Station station : route.getStations()){
            System.out.println(station.toString());
        }

    }
}
