package com.fmatusiak.travelagency.domain.skyscanner;

import com.fmatusiak.travelagency.config.skyscanner.SkyscannerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Component
public class SkyscannerClient {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private SkyscannerConfig skyscannerConfig;

    public Quotes getFlightsWithoutDepartureDates(final Flight flight) {
        URI url = UriComponentsBuilder
                .fromHttpUrl(skyscannerConfig.getEndpoint()
                + "PL/"
                + "PLN/"
                + "pl-PL/"
                        + flight.getArrivalCity() + "/"
                        + flight.getDepartureCity() + "/"
                        + flight.getArrivalDates())
                .build().encode().toUri();
        return restTemplate.postForObject(url, null, Quotes.class);
    }

    public Quotes getFlightsWithDepartureDates(final Flight flight) {
        URI url = UriComponentsBuilder.fromHttpUrl(skyscannerConfig.getEndpoint()
                + "PL/"
                + "PLN/"
                + "pl-PL/"
                + flight.getArrivalCity() + "/"
                + flight.getDepartureCity() + "/"
                + flight.getArrivalDates() + "/"
                + flight.getDepartureDates() + "?"
                + "apiKey="
                + skyscannerConfig.getKey())
                .build().encode().toUri();
        return restTemplate.postForObject(url, null, Quotes.class);
    }

}
