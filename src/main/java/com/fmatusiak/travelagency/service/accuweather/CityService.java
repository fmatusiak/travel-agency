package com.fmatusiak.travelagency.service.accuweather;

import com.fmatusiak.travelagency.client.accuweather.AccuweatherCityClient;
import com.fmatusiak.travelagency.domain.accuweather.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class CityService {

    @Autowired
    private AccuweatherCityClient accuweatherCityClient;

    public List<City> getTopCities(int numberCities) {
        return accuweatherCityClient.getTopCities(numberCities);
    }
}
