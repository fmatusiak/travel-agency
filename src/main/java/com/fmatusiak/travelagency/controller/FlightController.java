package com.fmatusiak.travelagency.controller;

import com.amadeus.exceptions.ResponseException;
import com.fmatusiak.travelagency.domain.amadeus.enums.TravelClass;
import com.fmatusiak.travelagency.domain.amadeus.flight.FlightOffer;
import com.fmatusiak.travelagency.mapper.amadeus.flight.FlightOfferMapper;
import com.fmatusiak.travelagency.service.amadeus.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/flight")
public class FlightController {

    @Autowired
    private FlightService flightService;

    @Autowired
    private FlightOfferMapper flightOfferMapper;

    @GetMapping(value = "getTravelClass")
    public List<TravelClass> getTravelClass(){
        return flightService.getTravelClass();
    }

    @GetMapping(value = "flightsbydate")
    public List<FlightOffer> findFlightsByDate(
            @RequestParam String originPlace
            , @RequestParam String destinationPlace
            , @RequestParam String date) throws ResponseException {
        return flightOfferMapper.FlightOfferAmadeusTabToFlightOfferListMapper(
                flightService.findFlightsByDate(originPlace, destinationPlace, date));
    }


}
