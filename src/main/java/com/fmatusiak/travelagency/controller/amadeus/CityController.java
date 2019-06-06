package com.fmatusiak.travelagency.controller.amadeus;

import com.fmatusiak.travelagency.domain.accuweather.City;
import com.fmatusiak.travelagency.service.accuweather.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/city")
public class CityController {
    @Autowired
    private CityService cityService;

    @GetMapping(value = "topcities/{citiesNumber}")
    public List<City> getTopCities(@PathVariable int citiesNumber) {
        return cityService.getTopCities(citiesNumber);
    }
}
