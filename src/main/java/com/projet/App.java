package com.projet;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
            Scanner scanner = new Scanner(System.in);   

            // Coordonees
            System.out.print("Entrez vos coordonnées (longitude, latitude) : ");
            int longitude = scanner.nextInt();
            int latitude = scanner.nextInt();

            Station stationDepart = metro.stationProche(longitude, latitude);

            // Choix de destination en deux methodes
            System.out.println("Choisissez le type de destination :");
            System.out.println("1. Par station");
            System.out.println("2. Par coordonnées");
            int destinationType = scanner.nextInt();

            Station destination = null;
            if (destinationType == 1) {
                // Nom de station
                System.out.print("Entrez le nom de la station : ");
                String stationName = scanner.next();

                destination = initMetro.stationParNom(metro.getStations(), stationName);

            } else if (destinationType == 2) {
                // coordonnées d'arrivé
                System.out.print("Entrez les coordonnées de destination (longitude, latitude) : ");
                int destLongitude = scanner.nextInt();
                int destLatitude = scanner.nextInt();

                destination = metro.stationProche(destLongitude, destLatitude);
                // Example: Station destinationStation = new Station("Destination", destLongitude, destLatitude);

            } else {
                System.out.println("Choix invalide. Fin du programme.");
                return;
            }

            // filtres
            // Prompt the user to set up the filter options
            System.out.println("Configuration du filtre :");
            System.out.println("1. Choisir la route la plus rapide en termes de temps de trajet");
            System.out.println("2. Choisir la route avec le moins de correspondances");
            System.out.println("3. Spécifier des stations");

            // Prompt the user for the filter options
            System.out.print("Choisissez une option : ");
            int option = scanner.nextInt();

            boolean plusRapide = false;
            boolean moinDeChangements = false;
            List<Station> stations = new ArrayList<>();

            switch (option) {
                case 1:
                    plusRapide = true;
                    break;
                case 2:
                    moinDeChangements = true;
                    break;
                case 3:
                    // Prompt the user to enter station names
                    System.out.println("Entrez les noms des stations (séparés par des virgules) : ");
                    String stationNames = scanner.next();
                    String[] stationArray = stationNames.split(",");
                    for (String stationName : stationArray) {
                        Station station = initMetro.stationParNom(metro.getStations(), stationName.trim());
                        // Add the station to the list of stations
                        // stations.add(station);
                    }
                    break;
                default:
                    System.out.println("Option invalide. Le filtre ne sera pas configuré.");
                    break;
            }

            Filtre filter = new Filtre(plusRapide, moinDeChangements, stations);

            System.out.println("-----Meilleur route entre : " + stationDepart.getNom() + " Vers " + destination.getNom() + "-----");

            Route route = metro.trouverRoute(stationDepart, destination, filter);
            for(Station s: route.getStations()){
                System.out.println(s.toString());
            }
            
            // Close the scanner
            scanner.close();
        }

    }

