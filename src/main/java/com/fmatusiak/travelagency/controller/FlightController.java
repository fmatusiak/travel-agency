package com.fmatusiak.travelagency.controller;

import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.FlightOffer;
import com.fmatusiak.travelagency.service.accuweather.amadeus.FlightsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/flight")
public class FlightController {

    @Autowired
    private FlightsService flightsService;

    @GetMapping(value = "flightsbydate")
    public FlightOffer[] findFlightsByDate(
            @RequestParam String originPlace
            , @RequestParam String destinationPlace
            , @RequestParam String date) throws ResponseException {
        return flightsService.findFlightsByDate(originPlace, destinationPlace, date);
    }


}
