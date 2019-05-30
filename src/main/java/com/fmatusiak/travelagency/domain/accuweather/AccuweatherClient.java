package com.fmatusiak.travelagency.domain.accuweather;

import com.fmatusiak.travelagency.config.accuweather.AccuweatherConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class AccuweatherClient {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private AccuweatherConfig accuweatherConfig;

    public List<City> getFindedCities(String cityName) {
        URI uri = UriComponentsBuilder
                .fromHttpUrl(accuweatherConfig.getEndpointLocationsCities())
                .queryParam("apikey", accuweatherConfig.getKey())
                .queryParam("q", cityName)
                .build().encode().toUri();
        return Arrays.asList(Optional.ofNullable(restTemplate.getForObject(uri, City[].class)).orElse(new City[0]));
    }

    public DailyForecasts getCheckWeatherByCityKey(int cityKey) {
        URI uri = UriComponentsBuilder
                .fromHttpUrl(accuweatherConfig.getEndpointForecasts() + cityKey)
                .queryParam("apikey", accuweatherConfig.getKey())
                .build().encode().toUri();
        return Optional.ofNullable(restTemplate.getForObject(uri, DailyForecasts.class)).orElse(null);
    }

    public List<City> getTopCities(int citiesNumber) {
        URI uri = UriComponentsBuilder
                .fromHttpUrl(accuweatherConfig.getEndpointLocationsCities() + citiesNumber)
                .queryParam("apikey", accuweatherConfig.getKey())
                .build().encode().toUri();
        return Arrays.asList(Optional.ofNullable(restTemplate.getForObject(uri, City[].class)).orElse(new City[0]));
    }


}
