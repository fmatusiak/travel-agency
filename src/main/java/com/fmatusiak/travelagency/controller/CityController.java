package com.fmatusiak.travelagency.controller;

import com.fmatusiak.travelagency.domain.accuweather.City;
import com.fmatusiak.travelagency.service.accuweather.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/city")
public class CityController {
    @Autowired
    private CityService cityService;

    @GetMapping(value = "cities/{cityName}")
    public List<City> getFindedCities(@PathVariable String cityName) {
        return cityService.getCitiesByCityName(cityName);
    }

    @GetMapping(value = "topcities/{citiesNumber}")
    public List<City> getTopCities(@PathVariable int citiesNumber) {
        return cityService.getTopCities(citiesNumber);
    }
}
