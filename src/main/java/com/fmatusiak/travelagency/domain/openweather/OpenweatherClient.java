package com.fmatusiak.travelagency.domain.openweather;

import com.fmatusiak.travelagency.config.openweather.OpenWeatherConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Component
public class OpenweatherClient {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private OpenWeatherConfig openWeatherConfig;

    public Weather findWeatherByCity(final WeatherProperty weatherProperty) {
        URI url = UriComponentsBuilder.fromHttpUrl(openWeatherConfig.getEnpoint() + "/weather")
                .queryParam("q", weatherProperty.getCityName())
                .queryParam("APPID", openWeatherConfig.getKey())
                .build().encode().toUri();
        return restTemplate.postForObject(url, null, Weather.class);
    }
}
