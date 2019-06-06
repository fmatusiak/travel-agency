package com.fmatusiak.travelagency.controller;

import com.amadeus.exceptions.ResponseException;
import com.fmatusiak.travelagency.domain.amadeus.enums.TravelClass;
import com.fmatusiak.travelagency.domain.amadeus.flight.Flight;
import com.fmatusiak.travelagency.domain.amadeus.flight.personalize.FlightPersonalizeBuilder;
import com.fmatusiak.travelagency.mapper.amadeus.flight.FlightOfferMapper;
import com.fmatusiak.travelagency.service.amadeus.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping(value = "flightsbydate/{originPlace}/{destinationPlace}" +
            "/{date}/{adults}/{children}/{seniors}/{travelClass}")
    public List<Flight> findFlightsByDate(
            @PathVariable String originPlace
            , @PathVariable String destinationPlace
            , @PathVariable String date
            , @PathVariable int adults
            , @PathVariable int children
            , @PathVariable int seniors
            , @PathVariable String travelClass) throws ResponseException {
        return flightOfferMapper.FlightOfferAmadeusTabToFlightOfferListMapper(
                flightService.findFlightsByDate(
                        new FlightPersonalizeBuilder()
                                .setOriginPlace(originPlace)
                                .setDestinationPlace(destinationPlace)
                                .setDepartureDate(date).setAdultsQuantity(adults)
                                .setChildrenQuantity(children).setSeniorsQuantity(seniors)
                                .setTravelClass(travelClass).createFlightPersonalize()));
    }


}
