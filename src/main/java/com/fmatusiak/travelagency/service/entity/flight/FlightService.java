package com.fmatusiak.travelagency.service.entity.flight;

import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.FlightOffer;
import com.fmatusiak.travelagency.client.amadeus.AmadeusFlightClient;
import com.fmatusiak.travelagency.domain.amadeus.enums.TravelClass;
import com.fmatusiak.travelagency.domain.amadeus.flight.personalize.FlightPersonalize;
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
    private AmadeusFlightClient amadeusFlightClient;

    public List<TravelClass> getTravelClass() {
        return amadeusFlightClient.getTravelClass();
    }

    public FlightOffer[] findFlightsByDate(FlightPersonalize flightPersonalize) throws ResponseException {
        return amadeusFlightClient.findFlightsByDate(flightPersonalize);
    }

}
