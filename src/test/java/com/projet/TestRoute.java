package com.projet;

import com.projet.models.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestRoute {
    private Station station1;
    private Station station2;
    private Station station3;
    private Station station4;
    private List<Station> stations;
    private List<Segment> segments;
    private Route route;

    @Before
    public void setup() {
        station1 = new Station("Station 1", 0, 0);
        station2 = new Station("Station 2", 1, 1);
        station3 = new Station("Station 3", 2, 2);
        station4 = new Station("Station 4", 3, 3);

        Segment segment1 = new Segment(station1, station2);
        Segment segment2 = new Segment(station2, station3);
        Segment segment3 = new Segment(station3, station4);

        stations = new ArrayList<>();
        stations.add(station1);
        stations.add(station2);
        stations.add(station3);
        stations.add(station4);

        segments = new ArrayList<>();
        segments.add(segment1);
        segments.add(segment2);
        segments.add(segment3);

        route = new Route(station1, station4, stations, segments);
    }

    @Test
    public void testCalculerTempsTrajet() {
        int expectedTotalTime = 0;
        for (Station station : stations) {
            expectedTotalTime += station.getDureeArret();
        }
        for (Segment segment : segments) {
            expectedTotalTime += segment.calculerTempsTrajet();
        }

        int actualTotalTime = route.calculerTempsTrajet();

        Assert.assertEquals(expectedTotalTime, actualTotalTime);
    }

    @Test
    public void testEstMeilleur() {
        List<Station> otherStations = new ArrayList<>();
        otherStations.add(station1);
        otherStations.add(station3);
        otherStations.add(station4);

        List<Segment> otherSegments = new ArrayList<>();
        otherSegments.add(segments.get(0));
        otherSegments.add(segments.get(2));

        Route otherRoute = new Route(station1, station4, otherStations, otherSegments);

        Filtre filter = new Filtre(true, false, null);

        Assert.assertTrue(route.estMeilleur(otherRoute, filter));
    }
}
