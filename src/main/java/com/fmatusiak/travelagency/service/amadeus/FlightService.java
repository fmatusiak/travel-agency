package com.fmatusiak.travelagency.service.amadeus;

import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.FlightOffer;
import com.fmatusiak.travelagency.domain.amadeus.AmadeusClient;
import com.fmatusiak.travelagency.domain.amadeus.enums.TravelClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FlightService {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private AmadeusClient amadeusClient;

    public List<TravelClass> getTravelClass(){
        return amadeusClient.getTravelClass();
    }

    public FlightOffer[] findFlightsByDate(String originPlace, String destinationPlace, String date) throws ResponseException {
        return amadeusClient.findFlightsByDate(originPlace, destinationPlace, date);
    }

}
