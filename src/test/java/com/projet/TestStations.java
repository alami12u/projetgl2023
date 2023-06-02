package com.projet;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import com.projet.models.Station;

public class TestStations {

    
    @Test
    public void testCalculerDistance() {
        Station station1 = new Station("Station 1", 0, 0);
        Station station2 = new Station("Station 2", 3, 4);
        
        double expectedDistance = 5.0;
        double actualDistance = station1.calculerDistance(station2);
        
        Assertions.assertEquals(expectedDistance, actualDistance, 0.01);
    }
    
    @Test
    public void testDureeArret() {
        Station station = new Station("Station", 0, 0, 3, false);
        
        int expectedDureeArret = 3;
        int actualDureeArret = station.getDureeArret();
        
        Assertions.assertEquals(expectedDureeArret, actualDureeArret);
    }
    
    @Test
    public void testIncidentStatus() {
        Station station1 = new Station("Station 1", 0, 0, 5, true);
        Station station2 = new Station("Station 2", 0, 0, 5, false);
        
        Assertions.assertTrue(station1.isIncident());
        Assertions.assertFalse(station2.isIncident());
    }
}
