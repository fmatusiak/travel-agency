package com.fmatusiak.travelagency.controller;

import com.fmatusiak.travelagency.domain.accuweather.DailyForecasts;
import com.fmatusiak.travelagency.service.accuweather.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/weather")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping(value = "checkweather/{cityKey}")
    public DailyForecasts getWeatherByCityKey(@PathVariable int cityKey) {
        return weatherService.getWeatherByCityKey(cityKey);
    }

}
