package com.fmatusiak.travelagency.client.accuweather;

import com.fmatusiak.travelagency.config.accuweather.AccuweatherConfig;
import com.fmatusiak.travelagency.domain.accuweather.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class AccuweatherCityClient {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private AccuweatherConfig accuweatherConfig;

    public List<City> getTopCities(int citiesNumber) {
        URI uri = UriComponentsBuilder
                .fromHttpUrl(accuweatherConfig.getEndpointLocationsCities() + citiesNumber)
                .queryParam("apikey", accuweatherConfig.getKey())
                .build().encode().toUri();
        return Arrays.asList(Optional.ofNullable(restTemplate.getForObject(uri, City[].class)).orElse(new City[0]));
    }
}
