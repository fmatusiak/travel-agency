package com.fmatusiak.travelagency.service.accuweather;

import com.fmatusiak.travelagency.domain.accuweather.AccuweatherClient;
import com.fmatusiak.travelagency.domain.accuweather.DailyForecasts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {

    @Autowired
    private AccuweatherClient accuweatherClient;

    public DailyForecasts checkWeatherByCityKey(int cityKey) {
        return accuweatherClient.checkWeatherByCityKey(cityKey);
    }
}
