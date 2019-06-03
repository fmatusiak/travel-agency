package com.fmatusiak.travelagency.controller;

import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.Location;
import com.fmatusiak.travelagency.service.amadeus.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/location")
public class LocationController {

    @Autowired
    private LocationService locationService;

    @GetMapping(value = "/citylistsearch/{keyword}")
    public Location[] getFindCityListSearchByKeyword(@PathVariable String keyword) throws ResponseException {
        return locationService.getFindCityListSearchByKeyword(keyword);
    }

    @GetMapping(value = "/airpotlistserach/{keyword}")
    public Location[] getFindAirportListSearchByKeyword(@PathVariable String keyword) throws ResponseException {
        return locationService.getFindAirportListSearchByKeyword(keyword);
    }

}
