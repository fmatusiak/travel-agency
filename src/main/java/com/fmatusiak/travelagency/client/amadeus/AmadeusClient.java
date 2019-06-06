package com.fmatusiak.travelagency.client.amadeus;

import com.amadeus.Amadeus;
import com.fmatusiak.travelagency.config.amadeus.AmadeusConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class AmadeusClient {

    private final static Logger LOGGER = Logger.getLogger(AmadeusClient.class.getName());

    @Autowired
    private AmadeusConfig amadeusConfig;

    public Amadeus getBuildAmadeus() {
        return Amadeus
                .builder(amadeusConfig.getKeyAmadeus(), amadeusConfig.getSecretAmadeus())
                .setLogger(LOGGER)
                .build();
    }
}
