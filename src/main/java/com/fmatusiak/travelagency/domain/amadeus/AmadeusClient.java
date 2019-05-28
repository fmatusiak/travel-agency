package com.fmatusiak.travelagency.domain.amadeus;

import com.amadeus.Amadeus;
import com.amadeus.Params;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.FlightOffer;
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

    public FlightOffer[] findFlightsByDate(String originPlace, String destinationPlace, String departureDate) throws ResponseException {
        return getBuildAmadeus().shopping.flightOffers.get(Params
                .with("origin", originPlace)
                .and("destination", destinationPlace)
                .and("departureDate", departureDate));
    }

}
