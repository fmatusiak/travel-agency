package com.fmatusiak.travelagency.config.amadeus;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class AmadeusConfig {

    @Value("${amadeus.key}")
    private String keyAmadeus;

    @Value("${amadeus.secret}")
    private String secretAmadeus;

}
