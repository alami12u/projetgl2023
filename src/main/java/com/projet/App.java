package com.projet;

import com.projet.initialisation.InitMetro;
import com.projet.models.Metro;

public class App 
{
    private static InitMetro initMetro = new InitMetro();
    public static void main( String[] args )
    {
        Metro metro = initMetro.init("data/Stations.txt", "data/Lignes.txt"); 
        System.out.println(metro.toString());
    }
}
