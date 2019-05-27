package com.fmatusiak.travelagency.domain.accuweather;

import com.fmatusiak.travelagency.config.accuweather.AccuweatherConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

@Component
public class AccuweatherClient {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private AccuweatherConfig accuweatherConfig;

    public List<City> getFindCity(String cityName) {
        URI uri = UriComponentsBuilder
                .fromHttpUrl(accuweatherConfig.getEndpointLocationsCities())
                .queryParam("apikey", accuweatherConfig.getKey())
                .queryParam("q", cityName)
                .build().encode().toUri();
        City[] cities = restTemplate.getForObject(uri, City[].class);
        return Arrays.asList(cities);
    }

}
