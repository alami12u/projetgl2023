package com.projet.models;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestLigne {
    private Ligne ligne;
    Station station1;
    Station station2;
    Station station3;

    @Before
    public void setup() {
        station1 = new Station("Station 1", 0, 0);
        station2 = new Station("Station 2", 1, 1);
        station3 = new Station("Station 3", 2, 2);

        Segment segment1 = new Segment(station1, station2);
        Segment segment2 = new Segment(station2, station3);

        List<Station> stations = new ArrayList<>();
        stations.add(station1);
        stations.add(station2);
        stations.add(station3);

        List<Segment> segments = new ArrayList<>();
        segments.add(segment1);
        segments.add(segment2);

        ligne = new Ligne("Ligne 1", stations, segments);
    }

    @Test
    public void testAjouterStation() {
        Station station4 = new Station("Station 4", 3, 3);

        ligne.ajouterStation(station4);

        List<Station> stations = ligne.getStations();

        Assert.assertTrue(stations.contains(station4));
    }

    @Test
    public void testGetSegment() {
        
        Segment segment = ligne.getSegment(station1, station2);
        Assert.assertNotNull(segment);

        Assert.assertTrue(segment.contient(station1));
        Assert.assertTrue(segment.contient(station2));
    }

    @Test
    public void testContient() {
        boolean containsStation2 = ligne.contient(station2);

        Assert.assertTrue(containsStation2);

        Station nonExistingStation = new Station("Station X", 4, 4);
        boolean containsNonExistingStation = ligne.contient(nonExistingStation);

        Assert.assertFalse(containsNonExistingStation);
    }

    @Test
    public void testGetCorrespendance() {
        Station station2_2 = new Station("Station 2", 5, 5);
        Station station3_2 = new Station("Station 3", 6, 6);

        List<Station> stations2 = new ArrayList<>();
        stations2.add(station2_2);
        stations2.add(station3_2);

        List<Segment> segments2 = new ArrayList<>();
        segments2.add(new Segment(station2_2, station3_2));

        Ligne ligne2 = new Ligne("Ligne 2", stations2, segments2);

        List<Station> correspendance = ligne.getCorrespendance(ligne2);

        Assert.assertTrue(correspendance.contains(station2));
        Assert.assertTrue(correspendance.contains(station3));
    }
}

