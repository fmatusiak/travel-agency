package com.fmatusiak.travelagency.controller.amadeus;

import com.amadeus.exceptions.ResponseException;
import com.fmatusiak.travelagency.domain.amadeus.location.LocationScore;
import com.fmatusiak.travelagency.mapper.amadeus.location.LocationMapper;
import com.fmatusiak.travelagency.service.amadeus.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/location")
public class LocationController {

    @Autowired
    private LocationService locationService;

    @Autowired
    private LocationMapper locationMapper;

    @GetMapping(value = "/citylistsearch/{keyword}")
    public List<LocationScore> getFindCityListSearchByKeyword(@PathVariable String keyword) throws ResponseException {
        return locationMapper.amadeusLocationTabToLocationList(locationService.getFindCityListSearchByKeyword(keyword));
    }

    @GetMapping(value = "/airpotlistserach/{keyword}")
    public List<LocationScore> getFindAirportListSearchByKeyword(@PathVariable String keyword) throws ResponseException {
        return locationMapper.amadeusLocationTabToLocationList(locationService.getFindAirportListSearchByKeyword(keyword));
    }

}
