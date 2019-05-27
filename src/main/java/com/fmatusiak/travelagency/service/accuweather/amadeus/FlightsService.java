package com.fmatusiak.travelagency.service.accuweather.amadeus;

import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.FlightOffer;
import com.fmatusiak.travelagency.domain.amadeus.AmadeusClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlightsService {

    @Autowired
    private AmadeusClient amadeusClient;

    public FlightOffer[] findFlightsByDate(String originPlace, String destinationPlace, String date) throws ResponseException {
        return amadeusClient.findFlightsByDate(originPlace, destinationPlace, date);
    }

}
