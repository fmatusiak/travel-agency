package com.fmatusiak.travelagency.mapper.amadeus.location;

import com.amadeus.exceptions.ResponseException;
import com.fmatusiak.travelagency.domain.amadeus.location.Location;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class LocationMapper {

    public List<Location> amadeusLocationTabToLocationList(final com.amadeus.resources.Location[] amadeusLocation) throws ResponseException {
        List<Location> locationList = new ArrayList<>();
        for (com.amadeus.resources.Location location1 : amadeusLocation) {
            locationList.add(new Location(
                    new Location.Data(
                            location1.getName()
                            , location1.getDetailedName()
                            , location1.getIataCode())
                    , new Location.Address(
                    location1.getAddress().getCityName()
                    , location1.getAddress().getCityCode()
                    , location1.getAddress().getCountryName())));
        }
        return locationList;
    }

}
