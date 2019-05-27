package com.fmatusiak.travelagency.config.accuweather;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class AccuweatherConfig {

    @Value("${accuweather.endpoint}")
    private String enpoint;

    @Value("${accuweather.endpoint.forecasts}")
    private String endpointForecasts;

    @Value("${accuweather.endpoint.locations.cities}")
    private String endpointLocationsCities;

    @Value("${accuweather.endpoint.locations.topcities}")
    private String endpointLocationsTopCities;

    @Value("${accuweather.key}")
    private String key;
}
