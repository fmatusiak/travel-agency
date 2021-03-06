package com.fmatusiak.travelagency.service.accuweather;

import com.fmatusiak.travelagency.client.accuweather.AccuweatherWeatherClient;
import com.fmatusiak.travelagency.domain.accuweather.City;
import com.fmatusiak.travelagency.domain.accuweather.DailyForecasts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class WeatherService {

    @Autowired
    private AccuweatherWeatherClient accuweatherWeatherClient;

    public DailyForecasts getWeatherByCityKey(int cityKey) {
        return accuweatherWeatherClient.getWeatherByCityKey(cityKey);
    }

    public List<City> getCitiesByCityName(String cityName) {
        return accuweatherWeatherClient.getCitiesByCityName(cityName);
    }

}
