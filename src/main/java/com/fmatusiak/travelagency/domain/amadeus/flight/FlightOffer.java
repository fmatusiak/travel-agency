package com.fmatusiak.travelagency.domain.amadeus.flight;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class FlightOffer {

    @JsonProperty("Data")
    Data data;

    static class Data {
        @JsonProperty("OfferItems")
        OfferItems offerItems;

        @JsonProperty("price")
        Price price;
    }

    static class OfferItems {
        @JsonProperty("Services")
        Services services;

    }

    static class Services {
        @JsonProperty("Segments")
        Segments segments;
    }

    static class Segments {
        @JsonProperty("FlightSegment")
        List<FlightSegment> flightSegment;
    }

    static class FlightSegment {
        @JsonProperty("Departure")
        Departure departure;

        @JsonProperty("Arrival")
        Arrival arrival;
    }

    static class Departure {
        @JsonProperty("iataCode")
        String iataCode;

        @JsonProperty("at")
        String at;
    }

    static class Arrival {
        @JsonProperty("iataCode")
        String iataCode;

        @JsonProperty("at")
        String at;
    }

    static class PricingDetailPerAdult {
        @JsonProperty("travelClass")
        String travelClass;

        @JsonProperty("availability")
        String availability;
    }


    static class Price {
        @JsonProperty("total")
        String total;
    }


}
