package com.fmatusiak.travelagency.service.accuweather;

import com.fmatusiak.travelagency.domain.accuweather.AccuweatherClient;
import com.fmatusiak.travelagency.domain.accuweather.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    @Autowired
    private AccuweatherClient accuweatherClient;

    public List<City> getCitiesByCityName(String cityName) {
        return accuweatherClient.getCitiesByCityName(cityName);
    }

    public List<City> getTopCities(int numberCities) {
        return accuweatherClient.getTopCities(numberCities);
    }
}
