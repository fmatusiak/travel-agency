package com.fmatusiak.travelagency.controller;

import com.amadeus.exceptions.ResponseException;
import com.fmatusiak.travelagency.domain.amadeus.enums.TravelClass;
import com.fmatusiak.travelagency.domain.amadeus.flight.FlightOffer;
import com.fmatusiak.travelagency.mapper.amadeus.flight.FlightOfferMapper;
import com.fmatusiak.travelagency.service.amadeus.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/flight")
public class FlightController {

    @Autowired
    private FlightService flightService;

    @Autowired
    private FlightOfferMapper flightOfferMapper;

    @GetMapping(value = "travelclass")
    public List<TravelClass> getTravelClass(){
        return flightService.getTravelClass();
    }

    @GetMapping(value = "flightsbydate/{originPlace}/{destinationPlace}/{date}")
    public List<FlightOffer> findFlightsByDate(
            @PathVariable String originPlace
            ,@PathVariable String destinationPlace
            ,@PathVariable String date) throws ResponseException {
        return flightOfferMapper.FlightOfferAmadeusTabToFlightOfferListMapper(
                flightService.findFlightsByDate(originPlace, destinationPlace, date));
    }


}
