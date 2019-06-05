package com.fmatusiak.travelagency.service.amadeus;

import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.FlightOffer;
import com.fmatusiak.travelagency.domain.amadeus.AmadeusClient;
import com.fmatusiak.travelagency.domain.amadeus.enums.TravelClass;
import com.fmatusiak.travelagency.domain.amadeus.flight.FlightPersonalize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class FlightService {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private AmadeusClient amadeusClient;

    public List<TravelClass> getTravelClass(){
        return amadeusClient.getTravelClass();
    }

    public FlightOffer[] findFlightsByDate(FlightPersonalize flightPersonalize) throws ResponseException {
        return amadeusClient.findFlightsByDate(flightPersonalize);
    }

}
