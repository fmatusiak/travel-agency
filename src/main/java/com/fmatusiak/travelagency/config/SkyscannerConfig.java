package com.fmatusiak.travelagency.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class SkyscannerConfig {
    @Value("${skyscanner.host}")
    private String skyscannerHost;

    @Value("${skyscanner.key}")
    private String skyscannerKey;
}
