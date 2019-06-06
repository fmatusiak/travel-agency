package com.fmatusiak.travelagency.domain.amadeus.flight;

import lombok.Getter;

@Getter
public class Flight {
    private FlightDeparture departure;
    private FlightArrival arrival;
    private FlightPriceDetailPerAdult pricingDetailPerAdult;
    private FlightPrice price;

    public Flight(FlightDeparture departure, FlightArrival arrival, FlightPriceDetailPerAdult pricingDetailPerAdult, FlightPrice price) {
        this.departure = departure;
        this.arrival = arrival;
        this.pricingDetailPerAdult = pricingDetailPerAdult;
        this.price = price;
    }
}
