package com.fmatusiak.travelagency.domain.amadeus;

import com.amadeus.Amadeus;
import com.amadeus.Params;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.FlightOffer;
import com.fmatusiak.travelagency.config.amadeus.AmadeusConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AmadeusClient {

    @Autowired
    private AmadeusConfig amadeusConfig;

    public Amadeus getBuildAmadeus() {
        return Amadeus
                .builder(amadeusConfig.getKeyAmadeus(), amadeusConfig.getSecretAmadeus())
                .build();
    }

    public FlightOffer[] findFlightsByDate(String originPlace, String destinationPlace, String date) throws ResponseException {
        return getBuildAmadeus().shopping.flightOffers.get(Params
                .with("origin", originPlace)
                .and("destination", destinationPlace)
                .and("departureDate", date));
    }

}
