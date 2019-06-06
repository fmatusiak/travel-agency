package com.fmatusiak.travelagency.service.amadeus;

import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.Location;
import com.fmatusiak.travelagency.client.amadeus.AmadeusLocationClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
public class LocationService {

    @Autowired
    private AmadeusLocationClient amadeusLocationClient;

    public Location[] getFindCityListSearchByKeyword(String keyword) throws ResponseException {
        return amadeusLocationClient.getFindCityListSearchByKeyword(keyword);
    }

    public Location[] getFindAirportListSearchByKeyword(String keyword) throws ResponseException {
        return amadeusLocationClient.getFindAirportListSearchByKeyword(keyword);
    }

}
