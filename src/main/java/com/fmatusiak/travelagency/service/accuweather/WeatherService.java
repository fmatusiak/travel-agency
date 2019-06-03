package com.fmatusiak.travelagency.service.accuweather;

import com.fmatusiak.travelagency.domain.accuweather.AccuweatherClient;
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
    private AccuweatherClient accuweatherClient;

    public DailyForecasts getWeatherByCityKey(int cityKey) {
        return accuweatherClient.getWeatherByCityKey(cityKey);
    }

    public List<City> getCitiesByCityName(String cityName) {
        return accuweatherClient.getCitiesByCityName(cityName);
    }


}
