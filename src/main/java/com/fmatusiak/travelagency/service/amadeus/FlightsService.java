package com.fmatusiak.travelagency.service.amadeus;

import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.FlightOffer;
import com.fmatusiak.travelagency.domain.amadeus.AmadeusClient;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FlightsService {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private AmadeusClient amadeusClient;

    public FlightOffer[] findFlightsByDate(String originPlace, String destinationPlace, String date) throws ResponseException {
        Gson gson = new Gson();
        String flightOffersJson = gson.toJson(amadeusClient.findFlightsByDate(originPlace, destinationPlace, date));
        return restTemplate.getForObject(flightOffersJson, FlightOffer[].class);
    }

}
