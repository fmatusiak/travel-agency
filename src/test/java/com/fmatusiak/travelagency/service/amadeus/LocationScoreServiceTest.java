package com.fmatusiak.travelagency.service.amadeus;

import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.Location;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LocationScoreServiceTest {

    @Autowired
    private LocationService locationService;

    @Test
    public void testFindCityListSearchByKeyword() throws ResponseException {
        //given
        Location[] locationCities = locationService.getFindCityListSearchByKeyword("LON");
        //when
        //then
        Assert.assertNotNull(locationCities);
    }

    @Test
    public void testFindAirportListSearchByKeyword() throws ResponseException {
        //given
        Location[] locationsAirports = locationService.getFindAirportListSearchByKeyword("LON");
        //when
        //then
        Assert.assertNotNull(locationsAirports);
    }
}