package com.fmatusiak.travelagency.domain.amadeus.flight;

import lombok.Getter;

@Getter
public class FlightOffer {
    private FlightDeparture departure;
    private FlightArrival arrival;
    private FlightPriceDetailPerAdult pricingDetailPerAdult;
    private FlightPrice price;

    public FlightOffer(FlightDeparture departure, FlightArrival arrival, FlightPriceDetailPerAdult pricingDetailPerAdult, FlightPrice price) {
        this.departure = departure;
        this.arrival = arrival;
        this.pricingDetailPerAdult = pricingDetailPerAdult;
        this.price = price;
    }
}
