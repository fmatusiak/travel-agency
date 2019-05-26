package com.fmatusiak.travelagency.config.openweather;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class OpenWeatherConfig {
    @Value("${openweather.endpoint}")
    private String enpoint;

    @Value("${openweather.key}")
    private String key;
}
