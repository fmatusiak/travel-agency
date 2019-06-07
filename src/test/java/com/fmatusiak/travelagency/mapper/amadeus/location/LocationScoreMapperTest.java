package com.fmatusiak.travelagency.mapper.amadeus.location;

import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.Location;
import com.fmatusiak.travelagency.domain.amadeus.location.LocationScore;
import com.fmatusiak.travelagency.service.amadeus.LocationService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LocationScoreMapperTest {

    @Autowired
    private LocationService locationService;

    @Autowired
    private LocationMapper locationMapper;

    @Test
    public void testAmadeusLocationTabToLocationList() throws ResponseException {
        //given
        Location[] locationCities = locationService.getFindCityListSearchByKeyword("LON");
        //when
        List<LocationScore> locationScoreList = locationMapper.amadeusLocationTabToLocationList(locationCities);
        //then
        Assert.assertNotNull(locationScoreList);
    }
}