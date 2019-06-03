package com.fmatusiak.travelagency.controller;

import com.fmatusiak.travelagency.domain.accuweather.City;
import com.fmatusiak.travelagency.domain.accuweather.DailyForecasts;
import com.fmatusiak.travelagency.service.accuweather.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/weather")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping(value = "weatherbycity/{cityKey}")
    public DailyForecasts getWeatherByCityKey(@PathVariable int cityKey) {
        return weatherService.getWeatherByCityKey(cityKey);
    }

    @GetMapping(value = "citiesbycityname/{cityName}")
    public List<City> getCitiesByCityName(@PathVariable String cityName) {
        return weatherService.getCitiesByCityName(cityName);
    }

}
