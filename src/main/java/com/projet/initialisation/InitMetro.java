package com.projet.initialisation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import com.projet.models.Ligne;
import com.projet.models.Metro;
import com.projet.models.Station;

/**
 * S'occupe de l'initialisation et le chargement du reseau du metro dans la memoire
 * Effectue cette operation à partir des données stockées dans data
 */
public class InitMetro{

    

    /**
     * Initialise le reseau a partir des données des stations et des lignes
     * @param cheminStations
     * @param cheminLignes
     * @return
     */
    public Metro init(String cheminStations, String cheminLignes){
        List<Station> stations = initStations(cheminStations);
        List<Ligne> lignes = initLignes(cheminLignes, stations);


        Metro metro = new Metro();
        metro.setStations(stations);
        metro.setLignes(lignes);
        return metro;
    }

    /**
     * Charge une liste des stations à partir du fichier des stations
     * Le fichier qui recap les données des stations à la structure suivante : <br></br>
     * Id ; Nom de la station ; longtitude ; latitude
     * <hr></hr>
     * @param cheminStations    Chemin vers le fichier des stations
     * @return                  List des stationss
     */
    public List<Station> initStations(String cheminStations){

        List<Station> stations = new ArrayList<>(); // Preparation de la liste des stations

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(getClass().getClassLoader().getResourceAsStream(cheminStations), StandardCharsets.UTF_8))) {
            String line;
            while((line=reader.readLine())!=null){
                String[] data = line.split(";");
                if(data.length < 4) throw new IOException("Donnée manquante pour la station : " + data[0]);
                stations.add(new Station(data[1].strip(),
                                        Integer.parseInt(data[2].strip()),
                                        Integer.parseInt(data[3].strip())));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());;
        }

        return stations;
    }

    /**
     * Retourn une list des lignes selon les données du fichier lignes
     * @param cheminLignes      chemin vers le fichier contenant les données lignes
     * @param stations          List des station du réseaux
     * @return List des lignes
     */
    public List<Ligne> initLignes(String cheminLignes, List<Station> stations){
        List<Ligne> lignes = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(getClass().getClassLoader().getResourceAsStream(cheminLignes), StandardCharsets.UTF_8))) {
            String line;
            while((line=reader.readLine())!=null){
                String[] splitLine = line.split(":");
                String nomLigne = splitLine[0].strip();     // Recuperer le nom de la ligne
                String stationsStr = splitLine[1].strip();  // La partie qui engendre l'ensemple des stations de la ligne
                String[] nomStations = stationsStr.substring(1, stationsStr.length()-1).split(";");
                // Suprimer l'espace autour des noms des stations
                for(int i=0; i<nomStations.length; i++) nomStations[i] = nomStations[i].strip();

                Ligne ligne = new Ligne(nomLigne);
                // L'ajout des stations à la ligne :
                for(String nomStation : nomStations){
                    Station station = stationParNom(stations, nomStation.strip());
                    if(station==null) throw new IOException("La station avec le nom : " + nomStation.strip() + " n'est pas trouvée");
                    ligne.ajouterStation(station);
                }             
                lignes.add(ligne);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return lignes;
    }

    /**
     * Trouve une instance Station par nom
     * @param stations      List des stations
     * @param nom           Nom de la station recherchée
     * @return              Station recherché sinon null si a station n'est pas trouvée
     */
    private Station stationParNom(List<Station> stations ,String nom){
        for(Station station: stations){
            if(station.getNom().equalsIgnoreCase(nom)) return station;
        }
        return null;
    }
}
