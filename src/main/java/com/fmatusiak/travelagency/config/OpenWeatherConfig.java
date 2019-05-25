package com.fmatusiak.travelagency.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class OpenWeatherConfig {
    @Value("${openweather.host}")
    private String openWeatherHost;

    @Value("${openweather.key}")
    private String openWeatherKey;
}
