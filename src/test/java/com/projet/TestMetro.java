package com.projet;

import com.projet.models.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestMetro {
    private Metro metro;
    private Station station1;
    private Station station2;
    private Station station3;
    private Ligne ligne1;
    private Ligne ligne2;

    @Before
    public void setup() {
        station1 = new Station("Station 1", 0, 0);
        station2 = new Station("Station 2", 1, 1);
        station3 = new Station("Station 3", 2, 2);

        List<Station> stations1 = new ArrayList<>();
        stations1.add(station1);
        stations1.add(station2);
        stations1.add(station3);

        ligne1 = new Ligne("Ligne 1", stations1, new ArrayList<>());

        List<Station> stations2 = new ArrayList<>();
        stations2.add(station2);
        stations2.add(station3);

        ligne2 = new Ligne("Ligne 2", stations2, new ArrayList<>());

        List<Ligne> lignes = new ArrayList<>();
        lignes.add(ligne1);
        lignes.add(ligne2);

        metro = new Metro(stations1, lignes);
    }

    @Test
    public void testStationProche() {
        Station closestStation = metro.stationProche(1, 1);

        Assert.assertEquals(station2, closestStation);
    }


}
