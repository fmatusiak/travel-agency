package com.fmatusiak.travelagency.mapper.amadeus.location;

import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.Location;
import com.fmatusiak.travelagency.domain.amadeus.location.LocationAddress;
import com.fmatusiak.travelagency.domain.amadeus.location.LocationData;
import com.fmatusiak.travelagency.domain.amadeus.location.LocationScore;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class LocationMapper {

    public List<LocationScore> amadeusLocationTabToLocationList(final Location[] amadeusLocation) throws ResponseException {
        List<LocationScore> locationScoreList = new ArrayList<>();
        for (com.amadeus.resources.Location location1 : amadeusLocation) {
            locationScoreList.add(new LocationScore(
                    new LocationData(location1.getName(), location1.getDetailedName(), location1.getIataCode())
                    , new LocationAddress(location1.getAddress().getCityName(), location1.getAddress().getCityCode()
                    , location1.getAddress().getCountryName())));
        }
        return locationScoreList;
    }

}
