package com.fmatusiak.travelagency.client.amadeus;


import com.amadeus.Params;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.referenceData.Locations;
import com.amadeus.resources.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AmadeusLocationClient {

    @Autowired
    private AmadeusClient amadeusClient;

    public Location[] getFindCityListSearchByKeyword(String keyword) throws ResponseException {
        return amadeusClient.getBuildAmadeus()
                .referenceData.locations
                .get(Params.with("keyword", keyword).and("subType", Locations.CITY));
    }

    public Location[] getFindAirportListSearchByKeyword(String keyword) throws ResponseException {
        return amadeusClient.getBuildAmadeus()
                .referenceData.locations
                .get(Params.with("keyword", keyword).and("subType", Locations.AIRPORT));
    }

}
