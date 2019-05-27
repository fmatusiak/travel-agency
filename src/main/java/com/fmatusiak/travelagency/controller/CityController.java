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

    @GetMapping(value = "findedcities")
    public List<City> getFindedCities(@RequestBody String cityName) {
        return cityService.getFindedCities(cityName);
    }

    @GetMapping(value = "topcities")
    public List<City> getTopCities(@RequestParam int citiesNumber) {
        return cityService.getTopCities(citiesNumber);
    }
}
