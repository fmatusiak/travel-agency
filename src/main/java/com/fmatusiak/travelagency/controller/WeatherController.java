package com.fmatusiak.travelagency.controller;

import com.fmatusiak.travelagency.domain.accuweather.DailyForecasts;
import com.fmatusiak.travelagency.service.accuweather.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/weather")
public class WeatherController {
    @Autowired
    private WeatherService weatherService;

    @GetMapping(value = "checkweather")
    public DailyForecasts checkWeatherByCityKey(@RequestParam int cityKey) {
        return weatherService.getCheckWeatherByCityKey(cityKey);
    }

}
