package com.fmatusiak.travelagency.config.skyscanner;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class SkyscannerConfig {

    @Value("${skyscanner.host}")
    private String host;

    @Value("${skyscanner.key}")
    private String key;

    @Value("${skyscanner.endpoint}")
    private String endpoint;
}
