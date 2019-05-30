package com.fmatusiak.travelagency.domain.amadeus.flight;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FlightOffer {
    private Departure departure;
    private Arrival arrival;
    private PricingDetailPerAdult pricingDetailPerAdult;
    private Price price;

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Departure {
        String iataCode;
        String at;
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Arrival {
        String iataCode;
        String at;
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PricingDetailPerAdult {
        String travelClass;
        int availability;
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Price {
        double total;
    }

}
